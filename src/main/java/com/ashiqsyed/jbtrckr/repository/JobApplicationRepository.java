package com.ashiqsyed.jbtrckr.repository;

import com.ashiqsyed.jbtrckr.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobApplicationRepository extends JpaRepository<JobApplication, UUID> {

}
