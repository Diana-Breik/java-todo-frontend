package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
   @Test
   @DirtiesContext
    public void addToDo() throws Exception {
        //GIVEN
       //WHEN
       mockMvc.perform(MockMvcRequestBuilders.post("/api/todo")
               .contentType(MediaType.APPLICATION_JSON)
               .content(""" 
                           {
                           "description": "testAddToDo",
                           "status": "OPEN"
                           }
"""))
       //THEN
               .andExpect(status().isOk())
               .andExpect(content().json("""

{
//ich muss da die ID nicht geben , weil sie da generiert wird und ich kenn sie gar nicht , aber was wichtig für mich ist, dass die ID schon existiert wird, das stelle ich mir sicher, anhand der nächsten Zeile mit andExpect.
                           "description": "testAddToDo",
                           "status": "OPEN"
                           }
"""))
               .andExpect(jsonPath("$.id").isNotEmpty());
   }


}