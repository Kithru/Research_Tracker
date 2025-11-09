package lk.ijse.cmjd.controller;

import lk.ijse.cmjd.model.User;
import lk.ijse.cmjd.service.DocumentService;
import lk.ijse.cmjd.service.MilestoneService;
import lk.ijse.cmjd.service.ProjectService;
import lk.ijse.cmjd.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class ViewController {

    private final ProjectService projectService;
    private final UserService userService;
    private final DocumentService documentService;
    private final MilestoneService milestoneService;

    public ViewController(ProjectService projectService,
            UserService userService,
            DocumentService documentService,
            MilestoneService milestoneService) {
        this.projectService = projectService;
        this.userService = userService;
        this.documentService = documentService;
        this.milestoneService = milestoneService;
    }

    // ==================== ROOT REDIRECT ====================
    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/login"; // redirect root URL to login page
    }

    // ==================== ADMIN ====================
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/admin/users")
    public String adminUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @GetMapping("/admin/projects")
    public String adminProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "admin/projects";
    }

    @GetMapping("/admin/documents")
    public String adminDocuments(Model model) {
        model.addAttribute("documents", documentService.getAllDocuments());
        return "admin/documents";
    }

    @GetMapping("/admin/milestones")
    public String adminMilestones(Model model) {
        model.addAttribute("milestones", milestoneService.getAllMilestones());
        return "admin/milestones";
    }

    // ==================== PI ====================
    @GetMapping("/pi/dashboard")
    public String piDashboard(Model model, Principal principal) {
        model.addAttribute("projects", projectService.getProjectsByPI(principal.getName()));
        return "pi/dashboard";
    }

    @GetMapping("/pi/my-projects")
    public String piProjects(Model model, Principal principal) {
        model.addAttribute("projects", projectService.getProjectsByPI(principal.getName()));
        return "pi/my-projects";
    }

    @GetMapping("/pi/project-details/{id}")
    public String piProjectDetails(@PathVariable String id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "pi/project-details";
    }

    // ==================== MEMBER ====================
    @GetMapping("/member/assigned-projects")
    public String memberProjects(Model model, Principal principal) {
        model.addAttribute("projects", projectService.getProjectsForMember(principal.getName()));
        return "member/assigned-projects";
    }

    @GetMapping("/member/milestone-form/{projectId}")
    public String memberMilestoneForm(@PathVariable String projectId, Model model) {
        model.addAttribute("project", projectService.getProjectById(projectId));
        return "member/milestone-form";
    }

    @GetMapping("/member/document-upload/{projectId}")
    public String memberDocumentUpload(@PathVariable String projectId, Model model) {
        model.addAttribute("project", projectService.getProjectById(projectId));
        return "member/document-upload";
    }

    // ==================== VIEWER ====================
    @GetMapping("/viewer/projects-list")
    public String viewerProjects(Model model) {
        model.addAttribute("projects", projectService.getPublicProjects());
        return "viewer/projects-list";
    }

    @GetMapping("/viewer/project-details/{id}")
    public String viewerProjectDetails(@PathVariable String id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "viewer/project-details";
    }

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
}
