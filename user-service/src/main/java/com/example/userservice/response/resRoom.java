package com.example.userservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class resRoom
{
    private Integer code;
    private String status;
    private String message;
    private Object data;
}
