package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long issueId , Long userid , String comment) throws Exception;

    void deleteComment(Long commentid, Long userid) throws Exception;
    List<Comment> findCommentByIssueId(Long issueId) throws Exception;
}
