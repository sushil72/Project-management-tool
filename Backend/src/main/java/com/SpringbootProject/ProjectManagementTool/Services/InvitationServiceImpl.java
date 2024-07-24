package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Invitation;
import com.SpringbootProject.ProjectManagementTool.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvitationServiceImpl implements  InvitationService{

    @Autowired
    private InvitationRepository invitationRepository;
    @Override
    public void sendInvitation(String email, Long projectId) {
        String Invitationtoken= UUID.randomUUID().toString();

        Invitation invitation = new Invitation();
        invitation.setEmail(email);
        invitation.setToken(Invitationtoken);
        invitation.setProjectId(projectId);
        invitationRepository.save(invitation);
    }

    @Override
    public Invitation acceptInvitation(String token, Long UserId) throws Exception {
        Invitation invitation = invitationRepository.findByToken(token);
        if (invitation==null)
        {
            throw new Exception("Invalid invitation token");
        }
        return invitation;
    }

    @Override
    public String getTokenByUserMail(String email) {
        return invitationRepository.findByEmail(email);
    }

    @Override
    public void deletetoken(String token) {
        invitationRepository.delete(invitationRepository.findByToken(token));
    }
}
