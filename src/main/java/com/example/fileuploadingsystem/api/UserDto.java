package com.example.fileuploadingsystem.api;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    public UserDto(String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
    }

    private String name;
    private String surname;
    private String login;
}