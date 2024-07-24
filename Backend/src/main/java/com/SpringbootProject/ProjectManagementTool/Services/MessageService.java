package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Message;

import java.util.List;

public interface MessageService {
    public Message sendMessage(Long senderId , Long projectId , String message) throws Exception;
    public List<Message> getMessageByProjectId(Long projectId) throws Exception;

}
