package com.alexandre.todolist.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TaskUpdateRequestDTO {
    @Size(min = 1, max = 100, message = "O título não pode ser vazio e deve ter no máximo 100 caracteres")
    private String title;

    private String description;

    @FutureOrPresent(message = "A data de vencimento não pode estar no passado")
    private LocalDateTime dueDate;

    private Boolean completed;

    public TaskUpdateRequestDTO(){};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
