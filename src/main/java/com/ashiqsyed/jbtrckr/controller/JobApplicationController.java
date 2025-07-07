package com.ashiqsyed.jbtrckr.controller;

import com.ashiqsyed.jbtrckr.config.JwtUtility;
import com.ashiqsyed.jbtrckr.model.JobApplication;
import com.ashiqsyed.jbtrckr.service.JobApplicationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/job-applications")
@CrossOrigin(origins = "http://localhost:3000")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;
    private final JwtUtility jwtUtility;

    public JobApplicationController(JobApplicationService jobApplicationService, JwtUtility jwtUtility) {
        this.jobApplicationService = jobApplicationService;
        this.jwtUtility = jwtUtility;
    }

    private Long getUserIdFromRequest(HttpServletRequest req) {
        String token = jwtUtility.extractTokenFromRequest(req);
        return jwtUtility.extractUserId(token);
    }

    //Gets all applications for the authenticated user
    @GetMapping
    public List<JobApplication> getApplications(HttpServletRequest req) {
        return jobApplicationService.getAllJobApplicationsByUser(getUserIdFromRequest(req));
    }

    //Adds a job application to the table
    @PostMapping
    public void addNewJobApplication(@RequestBody JobApplication newJob, HttpServletRequest req) {
        jobApplicationService.insertJobApplicationForUser(newJob, getUserIdFromRequest(req));
    }

    @GetMapping("{id}")
    public JobApplication getApplicationByIdAndUserId(@PathVariable UUID id, HttpServletRequest req) {
        return jobApplicationService.getJobApplicationByIdAndUserId(id, getUserIdFromRequest(req));
    }

    @PutMapping("{id}")
    public JobApplication updateJobApplication(@PathVariable UUID id, @RequestBody JobApplication update, HttpServletRequest req) {

        return jobApplicationService.updateJobApplicationById(id, update, getUserIdFromRequest(req));
    }

    @DeleteMapping("{id}")
    public void removeJobApplication(@PathVariable UUID id, HttpServletRequest req) {
        jobApplicationService.removeJobApplicationByIdAndUserId(id, getUserIdFromRequest(req));
    }
}
