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

    @GetMapping("/todo/{id}")
    public ToDo getToDoByID(@PathVariable String id){
        return toDoService.getToDoById(id);
    }

    @PutMapping("/todo/{id}")
    public ToDo editToDo(@PathVariable String id, @RequestBody ToDo toDoAfterEdit){
        return toDoService.editToDo(id,toDoAfterEdit);
    }
    @DeleteMapping("/todo/{id}")
    public void deleteToDo(@PathVariable String id){
        toDoService.deleteToDo(id);
    }

}
