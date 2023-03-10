package com.gmail.aba.controller;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.dto.ColumnDetailsDTO;
import com.gmail.aba.service.ColumnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/column")
public class ColumnController {
    ColumnService columnService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<ColumnData> create(@RequestBody ColumnData column) {
        Optional<ColumnData> columnData = null;
        if (column.getColumnName() != null && column.getColumnOrder() != null) {
            column.setFkColumn(1);
            columnService.createColumn(column);
            columnData = Optional.ofNullable(columnService.getLastRow());
        }
        return columnData;
    }

    @GetMapping("/{id}")
    public ColumnDetailsDTO getColumn(@PathVariable int id) {
        return columnService.getColumnById(id);
    }

    @PutMapping("/update/{id}")
    public String updateColumn(@RequestBody ColumnData column, @PathVariable int id) {
        return columnService.updateColumnName(column, id);
    }

    @PutMapping("/update/order/{id}")
    public String updateColumnOrder(@RequestBody ColumnData column, @PathVariable int id) {
        return columnService.updateColumnOrder(column, id);
    }

    @DeleteMapping("/{id}")
    public String deleteColumnById(@PathVariable int id) {
        columnService.deleteColumnById(id);

        return "Deleted";
    }

    @GetMapping("/getAll")
    public List<ColumnDetailsDTO> getAllColumn() {

        List<ColumnDetailsDTO> sortedList = columnService.getAllColumn().stream()
                .sorted(Comparator.comparingInt(ColumnDetailsDTO::getColumnOrder))
                .collect(Collectors.toList());

        return sortedList;

    }
}
