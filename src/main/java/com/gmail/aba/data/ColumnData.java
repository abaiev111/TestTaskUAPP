package com.gmail.aba.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ColumnData {
    private String columnName;
    private Integer columnOrder;
    private Integer fkColumn;

    public ColumnData(String columnName, Integer columnOrder) {
        this.columnName = columnName;
        this.columnOrder = columnOrder;
    }

    public ColumnData(String columnName) {
        this.columnName = columnName;
    }
}
