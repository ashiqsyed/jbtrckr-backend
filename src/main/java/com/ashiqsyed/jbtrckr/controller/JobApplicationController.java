package com.ashiqsyed.jbtrckr.controller;

import com.ashiqsyed.jbtrckr.model.JobApplication;
import com.ashiqsyed.jbtrckr.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/job-applications")
@CrossOrigin(origins = "http://localhost:3000")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping
    public List<JobApplication> getApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @PostMapping
    public void addNewJobApplication(@RequestBody JobApplication newJob) {
        jobApplicationService.insertJobApplication(newJob);
    }

    @GetMapping("{id}")
    public JobApplication getApplicationById(@PathVariable UUID id) {
        return jobApplicationService.getJobApplicationById(id);
    }

    @PutMapping("{id}")
    public JobApplication updateJobApplication(@PathVariable UUID id, @RequestBody JobApplication update ) {
        return jobApplicationService.updateJobApplicationById(id, update);
    }

    @DeleteMapping("{id}")
    public void removeJobApplication(@PathVariable UUID id) {
        jobApplicationService.removeJobApplicationById(id);
    }
}
