package lk.ijse.cmjd.controller;

import lk.ijse.cmjd.model.Document;
import lk.ijse.cmjd.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @GetMapping("/projects/{projectId}/documents")
    public ResponseEntity<List<Document>> list(@PathVariable String projectId) {
        return ResponseEntity.ok(service.getByProject(projectId));
    }

    @PostMapping("/projects/{projectId}/documents")
    public ResponseEntity<Document> upload(@PathVariable String projectId, @RequestBody Document doc) {
        return ResponseEntity.ok(service.createForProject(projectId, doc));
    }

    @DeleteMapping("/documents/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
