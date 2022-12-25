package com.example.device.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long userid;
    private Long roomid;
    private String deviceName;
    private Integer status;
}
