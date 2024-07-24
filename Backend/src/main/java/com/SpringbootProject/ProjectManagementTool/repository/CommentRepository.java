package com.SpringbootProject.ProjectManagementTool.repository;

import com.SpringbootProject.ProjectManagementTool.model.Comment;
import org.hibernate.annotations.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
        List<Comment> findByIssueId(Long  issueId);
}

