package com.example.backend;

import lombok.With;


public record ToDo(String id,
                   @With
                   String description,
                   @With
                   Status status)  {
}
