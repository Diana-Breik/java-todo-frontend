package com.example.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/todo")
    public List<ToDo> getAllToDo(){
      return toDoService.getToDoList();
    }

    @PostMapping("/todo")
    public ToDo addToDo(@RequestBody NewToDo newtoDo){
        return toDoService.save(newtoDo);
    }
}
