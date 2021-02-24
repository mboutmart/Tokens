package com.izicap.demo.token.controller.dtos;

import com.izicap.demo.token.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    
    public UserResponse(User u) {
        this.id = u.getId();
        this.username = u.getUserName();
    }
}
