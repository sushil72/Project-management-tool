package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Issue;
import com.SpringbootProject.ProjectManagementTool.model.User;
import com.SpringbootProject.ProjectManagementTool.request.IssueRequest;

import java.util.List;
import java.util.Optional;

public interface IssueService {
  Optional<Issue> getissueById(Long id) throws Exception;
    List<Issue> getIssueByProjectId(Long projectId) throws  Exception;
    Issue createIssue(IssueRequest issueRequest, User user) throws Exception;

 String deleteIssue(Long issueid , Long userid ) throws Exception;
    Issue addUSerToIssue(Long issueid, Long userid) throws Exception;
    Issue updateStatus(Long issueId, String status) throws Exception;




}
