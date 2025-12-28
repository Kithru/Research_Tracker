package lk.ijse.cmjd.controller;

import lk.ijse.cmjd.model.Milestone;
import lk.ijse.cmjd.service.MilestoneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MilestoneController {

    private final MilestoneService service;

    public MilestoneController(MilestoneService service) {
        this.service = service;
    }

    @GetMapping("/projects/{projectId}/milestones")
    public ResponseEntity<List<Milestone>> list(@PathVariable String projectId) {
        return ResponseEntity.ok(service.getByProject(projectId));
    }

    @PostMapping("/projects/{projectId}/milestones")
    public ResponseEntity<Milestone> create(@PathVariable String projectId, @RequestBody Milestone m) {
        return ResponseEntity.ok(service.createForProject(projectId, m));
    }

    @PutMapping("/milestones/{id}")
    public ResponseEntity<Milestone> update(@PathVariable String id, @RequestBody Milestone m) {
        return ResponseEntity.ok(service.update(id, m));
    }

    @DeleteMapping("/milestones/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
