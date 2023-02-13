package com.gmail.aba;

import com.gmail.aba.data.BoardData;
import com.gmail.aba.data.ColumnData;
import com.gmail.aba.dto.ColumnDetailsDTO;
import com.gmail.aba.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TaskUappApplication.class)
@AutoConfigureMockMvc
class TaskUappApplicationTests extends AbstractTest {

    @Autowired
    TaskService taskService;

    @Test
    public void testCreateColumn() throws Exception {
        ColumnData columnData = new ColumnData("columnName", 1);
        String inputJson = mapToJson(columnData);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/api/column/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);

    }

    @Test
    public void getColumnById() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/column/1")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ColumnDetailsDTO columnDetails = mapFromJson(content, ColumnDetailsDTO.class);

        assertEquals(1, columnDetails.getColumnId());
        assertEquals("columnName", columnDetails.getColumnName());
        assertEquals(1, columnDetails.getColumnOrder());
        assertEquals("boardName", columnDetails.getBoardName());
    }

    @Test
    public void getAllColumns() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/column/getAll")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ColumnDetailsDTO[] appleFactory = mapFromJson(content, ColumnDetailsDTO[].class);
        assertTrue(appleFactory.length > 0);
    }


    @Test
    void contextLoads() {
    }

}
