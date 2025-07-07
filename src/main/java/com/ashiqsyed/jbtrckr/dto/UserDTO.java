package com.ashiqsyed.jbtrckr.dto;

import java.util.List;

public class UserDTO {
    private String email;
    private String username;
    private long id;
    private List<JobApplicationDTO> jobApplications;

    public UserDTO() {

    }

    public UserDTO(String email, String username, long id) {
        this.email = email;
        this.username = username;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<JobApplicationDTO> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplicationDTO> jobApplications) {
        this.jobApplications = jobApplications;
    }
}
