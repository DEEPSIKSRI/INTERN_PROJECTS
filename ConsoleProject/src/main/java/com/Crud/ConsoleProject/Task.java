package com.Crud.ConsoleProject;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
public class Task {
    private static final AtomicInteger count = new AtomicInteger(0);

    private int id;
    private String taskName;
    private Date startDate;
    private Date endDate;
    private Date createdDate;
    private String title;
    private String description;
    private String createdBy;
    private Status status;
    private Boolean isAnnounced;
    private Date updatedOn;
    private Date deletedOn;
    private String updatedBy;
    private String deletedBy;

    public Task(String taskName, Date startDate, Date endDate, String title, String description, String createdBy, Status status, Boolean isAnnounced) {
        this.id = count.incrementAndGet();
        this.taskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdDate = new Date();
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.status = status;
        this.isAnnounced = isAnnounced;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createdDate=" + createdDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", status=" + status +
                ", isAnnounced=" + isAnnounced +
                ", updatedOn=" + updatedOn +
                ", deletedOn=" + deletedOn +
                ", updatedBy='" + updatedBy + '\'' +
                ", deletedBy='" + deletedBy + '\'' +
                '}';
    }
}