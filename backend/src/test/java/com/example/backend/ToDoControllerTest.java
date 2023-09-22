package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ToDoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ToDoRepository toDoRepository;
    @Test
    @DirtiesContext
    void getAllToDo() throws Exception {
        //GIVEN
        ToDo todo = new ToDo("1","testGetAllTodo",Status.OPEN);
        toDoRepository.save(todo);
        //WHEN
        mockMvc.perform(MockMvcRequestBuilders.get("/api/todo"))


           //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                          {
                          "id": "1",
                          "description": "testGetAllTodo",
                          "status": "OPEN"
                          }

                        ]
"""));

    }



}