package com.workflow.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private UUID id;

    private String username;

    private String password;
}
