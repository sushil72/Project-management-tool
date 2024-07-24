package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Issue;
import com.SpringbootProject.ProjectManagementTool.model.Project;
import com.SpringbootProject.ProjectManagementTool.model.User;
import com.SpringbootProject.ProjectManagementTool.repository.IssueRepositiory;
import com.SpringbootProject.ProjectManagementTool.request.IssueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueServiceImpl implements IssueService{
    @Autowired
    IssueRepositiory issueRepositiory;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Override
    public Optional<Issue> getissueById(Long id) throws Exception {
        return issueRepositiory.findById(id);
    }

    @Override
    public List<Issue> getIssueByProjectId(Long projectId) throws Exception {
        return issueRepositiory.findByProjectId(projectId);
    }

    @Override
    public Issue createIssue(IssueRequest issueRequest, User user) throws Exception {
        Project project = projectService.getProjectById(issueRequest.getProjectID());
        Issue issue = new Issue();
        issue.setProject(project);
        issue.setTitle(issueRequest.getTitle());
        issue.setDescription(issueRequest.getDescription());
        issue.setPriority(issueRequest.getPriority());
        issue.setDueDate(issueRequest.getDueDate());
        issue.setStatus(issueRequest.getStatus());

        return issueRepositiory.save(issue);
    }

    @Override
    public String deleteIssue(Long issueid, Long userid) throws Exception {
        issueRepositiory.deleteById(issueid);
        return "Deleted Issue " + issueid + " from user " + userid;
    }

    @Override
    public Issue addUSerToIssue(Long issueid, Long userid) throws Exception {
        User user = userService.findUserByid(userid);
        Optional<Issue> issue = getissueById(issueid);
        issue.get().setAssignee(user);
        return issueRepositiory.save(issue.get());
    }

    @Override
    public Issue updateStatus(Long issueId, String status) throws Exception {
        Optional<Issue> issue =getissueById((issueId));
        issue.get().setStatus(status);
        return issueRepositiory.save(issue.get());
    }
}
