package com.SpringbootProject.ProjectManagementTool.controller;

import com.SpringbootProject.ProjectManagementTool.Services.MessageService;
import com.SpringbootProject.ProjectManagementTool.Services.MessageServiceImpl;
import com.SpringbootProject.ProjectManagementTool.Services.ProjectService;
import com.SpringbootProject.ProjectManagementTool.Services.UserService;
import com.SpringbootProject.ProjectManagementTool.model.Chat;
import com.SpringbootProject.ProjectManagementTool.model.Message;
import com.SpringbootProject.ProjectManagementTool.model.User;
import com.SpringbootProject.ProjectManagementTool.repository.MessageRepository;
import com.SpringbootProject.ProjectManagementTool.request.CreateMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;
    @Autowired
    MessageService messageService;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageServiceImpl messageServiceImpl;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request) throws Exception {
        User user = userService.findUserByid(request.getSenderId());
        Chat chat = projectService.getProjectById(request.getProjectId()).getChat();
        if(chat==null) throw new Exception("Chat not found");

            Message sentMessage =messageService.sendMessage(request.getSenderId(),
                    request.getProjectId(), request.getContent());
            return ResponseEntity.ok(sentMessage);
    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessageByChatId(@PathVariable Long projectId) throws Exception {
        List<Message> messages = messageService.getMessageByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }
}
