package com.gmail.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDetailsDTO {

    private Long taskId;
    private String taskName;
    private String taskDescription;
    private Integer taskOrder;
    private String taskDate;
    private String columnName;

}
