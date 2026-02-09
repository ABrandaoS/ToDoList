package com.alexandre.todolist.dto;

import com.alexandre.todolist.domain.enums.Priority;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TaskRequestDTO {
    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 100, message = "O título não pode ser vazio e deve ter no mínimo 5 e máximo 100 caracteres")
    private String title;

    @NotNull(message = "A descrição não pode ser nula")
    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres")
    private String description;

    @NotNull(message = "A data de vencimento não pode ser nula")
    @FutureOrPresent(message = "A data de vencimento deve ser futura")
    private LocalDateTime dueDate;

    @NotNull(message = "A prioridade não pode ser nula")
    private Priority priority;



    public TaskRequestDTO(){};

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
