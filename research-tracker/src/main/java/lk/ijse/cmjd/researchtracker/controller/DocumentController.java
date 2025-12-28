package lk.ijse.cmjd.researchtracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd.researchtracker.model.Document;
import lk.ijse.cmjd.researchtracker.service.DocumentService;

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
