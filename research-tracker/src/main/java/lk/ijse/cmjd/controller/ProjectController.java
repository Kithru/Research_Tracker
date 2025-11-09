package lk.ijse.cmjd.controller;

import lk.ijse.cmjd.model.Project;
import lk.ijse.cmjd.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Project>> all() {
        return ResponseEntity.ok(service.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable String id) {
        return ResponseEntity.ok(service.getProjectById(id));
    }

    @PreAuthorize("hasAnyRole('ADMIN','PI')")
    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {
        return ResponseEntity.ok(service.createProject(project));
    }

    @PreAuthorize("hasAnyRole('ADMIN','PI')")
    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable String id, @RequestBody Project project) {
        return ResponseEntity.ok(service.updateProject(id, project));
    }

    @PreAuthorize("hasAnyRole('ADMIN','PI')")
    @PatchMapping("/{id}/status")
    public ResponseEntity<Project> updateStatus(@PathVariable String id, @RequestBody StatusUpdate body) {
        return ResponseEntity.ok(service.updateStatus(id, body.status()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    public static record StatusUpdate(String status) {

    }
}
