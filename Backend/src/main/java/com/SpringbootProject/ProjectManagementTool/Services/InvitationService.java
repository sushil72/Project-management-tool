package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Invitation;

public interface InvitationService {

    public void sendInvitation(String email , Long projectId);

    public Invitation acceptInvitation(String toiken ,  Long UserId ) throws Exception;

    public String getTokenByUserMail(String email);

    void deletetoken(String token);

}
