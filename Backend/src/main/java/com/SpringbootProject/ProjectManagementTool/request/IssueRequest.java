package com.SpringbootProject.ProjectManagementTool.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueRequest {
    private String title;
    private String description;
    private String status;
    private String priority;
    private Long projectID;
    private LocalDate dueDate;
}
