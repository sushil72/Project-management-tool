package com.SpringbootProject.ProjectManagementTool.controller;

import com.SpringbootProject.ProjectManagementTool.Services.CommentService;
import com.SpringbootProject.ProjectManagementTool.Services.UserService;
import com.SpringbootProject.ProjectManagementTool.model.Comment;
import com.SpringbootProject.ProjectManagementTool.model.User;
import com.SpringbootProject.ProjectManagementTool.request.CreateCommentRequest;
import com.SpringbootProject.ProjectManagementTool.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> addComment(@RequestBody CreateCommentRequest createCommentRequest, @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByEmail(jwt);
        Comment createdComment = commentService.createComment(createCommentRequest.getIssueId(),
                user.getId(),
                createCommentRequest.getContent());
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);

    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        commentService.deleteComment(commentId, user.getId());
        MessageResponse msg  = new MessageResponse("Comment deleted");
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/{issueId}")
    public ResponseEntity<List<Comment>> getCommentByIssueId(@PathVariable Long issueId ) throws Exception {
        return new ResponseEntity<>(commentService.findCommentByIssueId(issueId), HttpStatus.OK);
    }

}
