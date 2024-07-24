package com.SpringbootProject.ProjectManagementTool.Services;

import com.SpringbootProject.ProjectManagementTool.model.Chat;
import com.SpringbootProject.ProjectManagementTool.model.Message;
import com.SpringbootProject.ProjectManagementTool.model.User;
import com.SpringbootProject.ProjectManagementTool.repository.ChatRepository;
import com.SpringbootProject.ProjectManagementTool.repository.MessageRepository;
import com.SpringbootProject.ProjectManagementTool.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private ProjectService projectService;

    @Autowired
    UserRepo userRepository;

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message sendMessage(Long senderId, Long projectId, String content) throws Exception {
        User user = userRepository.findById(senderId).orElseThrow(()->new Exception("User not found with id : "+senderId));
        Chat chat =  projectService.getChatByProjectId(projectId).getProject().getChat();
        Message msg = new Message();
        msg.setContent(content);
        msg.setCreatedAt(LocalDateTime.now());
        msg.setChat(chat);
        Message savedMsg = messageRepository.save(msg);
        chat.getMessages().add(savedMsg);
        return savedMsg;
    }

    @Override
    public List<Message> getMessageByProjectId(Long projectId) throws Exception {
        Chat chat =  projectService.getChatByProjectId(projectId).getProject().getChat();
        return messageRepository.findByChatOrderByCreatedAtAsc(chat);
    }


}
