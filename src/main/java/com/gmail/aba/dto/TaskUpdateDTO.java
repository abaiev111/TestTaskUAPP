package com.gmail.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskUpdateDTO {
    private String taskName;
    private String taskDescription;
    private LocalDate taskDate;

}
