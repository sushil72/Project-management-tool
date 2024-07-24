package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Comment;
import com.SpringbootProject.ProjectManagementTool.model.Issue;
import com.SpringbootProject.ProjectManagementTool.model.User;
import com.SpringbootProject.ProjectManagementTool.repository.CommentRepository;
import com.SpringbootProject.ProjectManagementTool.repository.IssueRepositiory;
import com.SpringbootProject.ProjectManagementTool.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private IssueRepositiory issueRepository;

    @Autowired
    private UserRepo userRepository;

    @Override
    public Comment createComment(Long issueId, Long userid, String content) throws Exception {
        Optional<Issue> issueOptional = issueRepository.findById(issueId);
        Optional<User> userOptional = userRepository.findById(userid);
        if (issueOptional.isEmpty() || userOptional.isEmpty()) {
            throw new Exception("Issue with id " + issueId + " not found");
        }
        Issue issue = issueOptional.get();
        User user = userOptional.get();
        Comment comment = new Comment();
        comment.setIssue(issue);
        comment.setUser(user);
        comment.setContent(content);
        comment.setCreatedDateTime(LocalDateTime.now());
        Comment SavedComment = commentRepository.save(comment);
        issue.getComments().add(SavedComment);
        return SavedComment;
    }

    @Override
    public void deleteComment(Long issueId, Long userid) throws Exception {
        Optional<Comment> commentOptional = commentRepository.findById(issueId);
        Optional<User> userOptional = userRepository.findById(userid);
        if (commentOptional.isEmpty() || userOptional.isEmpty()) {
            throw new Exception("Issue with id " + issueId + " not found");
        }

        Comment comment = commentOptional.get();
        User user = userOptional.get();
        if (comment.getUser().equals(user))
            commentRepository.delete(comment);
        else {
            throw new Exception("Issue with id " + issueId + " is not owned by user " + userid);
        }
    }



    @Override
    public List<Comment> findCommentByIssueId(Long issueId) throws Exception {

        return commentRepository.findByIssueId(issueId);
    }
}
