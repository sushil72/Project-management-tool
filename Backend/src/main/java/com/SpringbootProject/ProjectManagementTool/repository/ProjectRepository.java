package com.SpringbootProject.ProjectManagementTool.repository;

import com.SpringbootProject.ProjectManagementTool.model.Project;
import com.SpringbootProject.ProjectManagementTool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
//    List<Project> findByProjectName(String projectName);
//    List<Project>findByUser(User user);
//    List<Project>findByNameCotainingAndTeamContaining(String projectName, String teamName);

//    @Query("SELECT  p from  Project  p join p.team  t where  t=:user")
//    List<Project>findProjectByTeam(@Param("user") User user);

    List<Project>findByTeamContainingOrOwner(User owner, User user);

    List<Project> findByNameContainingAndTeamContains(String keyword, User user);
}
