package com.SpringbootProject.ProjectManagementTool.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMessageRequest {
    private Long SenderId;
    private String content;
    private Long projectId;
}

