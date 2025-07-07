package com.ashiqsyed.jbtrckr.mapper;

import com.ashiqsyed.jbtrckr.dto.JobApplicationDTO;
import com.ashiqsyed.jbtrckr.model.JobApplication;

public class JobApplicationMapper {
    public static JobApplicationDTO toDTO(JobApplication jobApplication) {
        if (jobApplication == null) {
            return null;
        }
        return new JobApplicationDTO(jobApplication.getId(), jobApplication.getCompany(), jobApplication.getTitle(), jobApplication.getStatus(), jobApplication.getDateApplied());

    }
}
