package com.gmail.aba.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskData {
    private String taskName;
    private String taskDescription;
    private LocalDate taskDate;
    private Integer taskOrder;
    private Integer fkTask;
}
