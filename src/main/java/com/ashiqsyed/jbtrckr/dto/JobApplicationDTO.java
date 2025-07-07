package com.ashiqsyed.jbtrckr.dto;

import java.time.LocalDate;

import java.util.UUID;

public class JobApplicationDTO {
    private UUID id;
    private String company;
    private String title;
    private String status;
    private LocalDate dateApplied;

    public JobApplicationDTO() {

    }

    public JobApplicationDTO(UUID id, String company, String title, String status, LocalDate dateApplied) {
        this.id = id;
        this.company = company;
        this.title = title;
        this.status = status;
        this.dateApplied = dateApplied;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }


}
