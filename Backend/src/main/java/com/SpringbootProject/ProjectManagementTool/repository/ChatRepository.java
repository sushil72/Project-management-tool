package com.SpringbootProject.ProjectManagementTool.repository;

import com.SpringbootProject.ProjectManagementTool.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
