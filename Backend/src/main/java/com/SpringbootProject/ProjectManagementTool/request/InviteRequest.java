package com.SpringbootProject.ProjectManagementTool.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InviteRequest {
    Long projectId;
    String email;
}
