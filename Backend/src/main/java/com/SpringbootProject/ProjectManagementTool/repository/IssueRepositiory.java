package com.SpringbootProject.ProjectManagementTool.repository;

import com.SpringbootProject.ProjectManagementTool.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepositiory extends JpaRepository<Issue, Long> {
    List<Issue> findByProjectId(Long projectId);
}
