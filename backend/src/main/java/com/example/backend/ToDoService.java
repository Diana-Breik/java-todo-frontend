package com.example.backend;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private int i =1;
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getToDoList() {
        return toDoRepository.findAll();
    }

    public ToDo save(NewToDo newtoDo) {
        ToDo toDo=new ToDo(UUID.randomUUID().toString(), newtoDo.description(),newtoDo.status());
        return toDoRepository.save(toDo);
    }
}
