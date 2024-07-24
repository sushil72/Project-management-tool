package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Chat;
import com.SpringbootProject.ProjectManagementTool.model.Project;
import com.SpringbootProject.ProjectManagementTool.model.User;

import java.util.List;

public interface ProjectService {
        public Project createProject(Project project , User user) throws Exception;

        List<Project>getAllProjectByTeam(User user , String category , String tag) throws Exception;

        Project getProjectById(Long id) throws Exception;

        void deleteProject(Long pid , Long uid) throws Exception;

        Project updateProject( Project updatedProject ,Long id ) throws Exception;

        void addUserToProject(Long projectId, Long userId) throws Exception;

        void remobeUserFromProject(Long projectId, Long userId) throws Exception;

        Chat getChatByProjectId(Long projectId) throws Exception;

        List<Project> searchProjects(String keyword, User user );
}
