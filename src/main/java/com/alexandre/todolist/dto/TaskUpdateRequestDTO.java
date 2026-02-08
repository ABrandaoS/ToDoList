package com.alexandre.todolist.dto;

import com.alexandre.todolist.domain.enums.Priority;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TaskUpdateRequestDTO {
    @Size(min = 5, max = 100, message = "O título não pode ser vazio e deve ter no máximo 100 caracteres")
    @NotNull(message = "O título não pode ser nulo")
    private String title;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    @NotNull(message = "A descrição não pode ser nula")
    private String description;

    @FutureOrPresent(message = "A data de vencimento não pode estar no passado")
    @NotNull(message = "A data de vencimento não pode ser nula")
    private LocalDateTime dueDate;

    @NotNull(message = "A situação não pode ser nula")
    private Boolean completed;

    @NotNull(message = "A prioridade não pode ser nula")
    private Priority priority;



    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

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
