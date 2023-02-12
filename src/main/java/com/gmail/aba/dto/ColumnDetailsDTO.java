package com.gmail.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ColumnDetailsDTO {

    private Long columnId;
    private String columnName;
    private Integer columnOrder;

    private String boardName;

}
