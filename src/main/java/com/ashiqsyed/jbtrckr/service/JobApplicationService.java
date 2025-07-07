package com.ashiqsyed.jbtrckr.service;

import com.ashiqsyed.jbtrckr.model.JobApplication;
import com.ashiqsyed.jbtrckr.model.User;
import com.ashiqsyed.jbtrckr.repository.JobApplicationRepository;
import com.ashiqsyed.jbtrckr.repository.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepo;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepo) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.userRepo = userRepo;
    }

    /**
     * Inserts a job into the table
     * @param job job object to be added
     */
    public void insertJobApplicationForUser(JobApplication job, Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        job.setUser(user);

        jobApplicationRepository.save(job);
    }

    /**
     *  Returns all job applications in the table
     * @return list of job applications
     */
    public List<JobApplication> getAllJobApplicationsByUser(Long userId) {
        return jobApplicationRepository.findByUserId(userId);
    }

    /**
     * Returns a specific job application
     * @param id job application id
     * @return job application with the given id
     */
    public JobApplication getJobApplicationByIdAndUserId(UUID id, Long userId) {
        return jobApplicationRepository.findByIdAndUserId(id, userId).orElseThrow(() -> new IllegalStateException("Job Application with id " + id + " not found"));
    }

    /**
     * Updates the row in a table corresponding to a certain job application.
     * @param id job application to be updated
     * @param newInfo new information to update the job application with
     */
    public JobApplication updateJobApplicationById(UUID id, JobApplication newInfo, Long userId) {
        JobApplication existingJob = jobApplicationRepository.findByIdAndUserId(id, userId).orElseThrow(() -> new IllegalStateException("Job Application with id " + id + " not found"));
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
    public void removeJobApplicationByIdAndUserId(UUID id, Long userId) {
        JobApplication job = jobApplicationRepository.findByIdAndUserId(id, userId).orElseThrow(() -> new AccessDeniedException("Application not found."));
        jobApplicationRepository.delete(job);
    }



}
