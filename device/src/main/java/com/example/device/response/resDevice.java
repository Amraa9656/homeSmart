package com.example.device.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class resDevice
{
    private Integer code;
    private String status;
    private String message;
    private Object data;
}
