package lk.ijse.cmjd.controller;

import lk.ijse.cmjd.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ViewController {

    private final ProjectService projectService;

    public ViewController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Admin Views
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/admin/users")
    public String adminUsers() {
        return "admin/users";
    }

    @GetMapping("/admin/projects")
    public String adminProjects() {
        return "admin/projects";
    }

    @GetMapping("/admin/documents")
    public String adminDocuments() {
        return "admin/documents";
    }

    @GetMapping("/admin/milestones")
    public String adminMilestones() {
        return "admin/milestones";
    }

    // PI Views
    @GetMapping("/pi/dashboard")
    public String piDashboard(Model model, Principal principal) {
        // load projects assigned to PI
        model.addAttribute("projects", projectService.getProjectsByPI(principal.getName()));
        return "pi/dashboard";
    }

    @GetMapping("/pi/my-projects")
    public String piProjects(Model model, Principal principal) {
        model.addAttribute("projects", projectService.getProjectsByPI(principal.getName()));
        return "pi/my-projects";
    }

    @GetMapping("/pi/project-details/{id}")
    public String piProjectDetails() {
        return "pi/project-details";
    }

    // Member Views
    @GetMapping("/member/assigned-projects")
    public String memberProjects(Model model, Principal principal) {
        model.addAttribute("projects", projectService.getProjectsForMember(principal.getName()));
        return "member/assigned-projects";
    }

    @GetMapping("/member/milestone-form/{projectId}")
    public String memberMilestoneForm() {
        return "member/milestone-form";
    }

    @GetMapping("/member/document-upload/{projectId}")
    public String memberDocumentUpload() {
        return "member/document-upload";
    }

    // Viewer Views
    @GetMapping("/viewer/projects-list")
    public String viewerProjects(Model model) {
        model.addAttribute("projects", projectService.getPublicProjects());
        return "viewer/projects-list";
    }

    @GetMapping("/viewer/project-details/{id}")
    public String viewerProjectDetails() {
        return "viewer/project-details";
    }

    // Login
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
