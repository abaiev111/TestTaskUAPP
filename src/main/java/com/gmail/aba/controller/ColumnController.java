package com.gmail.aba.controller;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.dto.ColumnDetailsDTO;
import com.gmail.aba.service.ColumnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/column")
public class ColumnController {
    ColumnService columnService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ColumnData create(@RequestBody ColumnData columnData) {
        columnService.createColumn(columnData);
        return columnService.getLastRow();
    }

    @GetMapping("/{id}")
    public ColumnDetailsDTO getColumn(@PathVariable int id) {
        return columnService.getColumnById(id);
    }

    @PutMapping("/update/name/{id}")
    public String updateColumnByName(@RequestBody ColumnData column, @PathVariable int id) {
        return columnService.updateColumnByName(column, id);
    }

    @PutMapping("/update/order/{id}")
    public String updateColumnByOrder(@RequestBody ColumnData column, @PathVariable int id) {
        return columnService.updateColumnByOrder(column, id);
    }

    @DeleteMapping("/delete/{id}")
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
