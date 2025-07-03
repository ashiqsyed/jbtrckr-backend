package com.ashiqsyed.jbtrckr.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
public class JobApplication {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    private String company;
    private String status;
    private LocalDate dateApplied;
    private String title;


    public JobApplication() {
//        this.id = UUID.randomUUID();
    }

    public JobApplication(UUID id, String company, String status, LocalDate dateApplied, String title) {
//        this.id = UUID.randomUUID();
        this.company = company;
        this.status = status;
        this.dateApplied = dateApplied;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobApplication that = (JobApplication) o;
        return id == that.id && Objects.equals(company, that.company) && Objects.equals(status, that.status) && Objects.equals(dateApplied, that.dateApplied) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, status, dateApplied, title);
    }
}
