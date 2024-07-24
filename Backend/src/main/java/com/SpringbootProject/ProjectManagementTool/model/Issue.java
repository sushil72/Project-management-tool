package com.SpringbootProject.ProjectManagementTool.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Issue{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;
    private String priority;
    private Long projectID;

    private LocalDate dueDate;

    private List<String> tags = new ArrayList<>();
    @JsonIgnore
    @OneToMany
    private List<Comment> comments = new ArrayList<>();
    @ManyToOne
    private User assignee;

    @JsonIgnore
    @ManyToOne
    private Project project;
}
