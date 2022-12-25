package com.example.userservice.model;

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
public class Room
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private Long userid;
    private String roomType;
    private Integer temperatureValue;
    private Integer lightningValue;
}
