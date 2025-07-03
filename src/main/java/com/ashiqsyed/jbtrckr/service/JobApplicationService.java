package com.ashiqsyed.jbtrckr.service;

import com.ashiqsyed.jbtrckr.model.JobApplication;
import com.ashiqsyed.jbtrckr.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    /**
     * Inserts a job into the table
     * @param job job object to be added
     */
    public void insertJobApplication(JobApplication job) {
        System.out.println(job.getDateApplied());
        jobApplicationRepository.save(job);
    }

    /**
     *  Returns all job applications in the table
     * @return list of job applications
     */
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    /**
     * Returns a specific job application
     * @param id job application id
     * @return job application with the given id
     */
    public JobApplication getJobApplicationById(UUID id) {
        return jobApplicationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Job Application with id " + id + " not found"));
    }

    /**
     * Updates the row in a table corresponding to a certain job application.
     * @param id job application to be updated
     * @param newInfo new information to update the job application with
     */
    public JobApplication updateJobApplicationById(UUID id, JobApplication newInfo) {
        JobApplication existingJob = jobApplicationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Job Application with id " + id + " not found"));
        existingJob.setCompany(newInfo.getCompany());
        existingJob.setTitle(newInfo.getTitle());
        existingJob.setStatus(newInfo.getStatus());
        existingJob.setDateApplied(newInfo.getDateApplied());

        return jobApplicationRepository.save(existingJob);
    }

    /**
     * Removes a specific job application from the database with the given id
     * @param id job application id
     */
    public void removeJobApplicationById(UUID id) {
        JobApplication job = jobApplicationRepository.findById(id).orElseThrow(() -> new IllegalStateException("Job Application with id " + id + " not found"));
        jobApplicationRepository.delete(job);
    }



}
