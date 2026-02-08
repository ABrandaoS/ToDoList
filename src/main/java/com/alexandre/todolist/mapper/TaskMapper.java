package com.alexandre.todolist.mapper;

import com.alexandre.todolist.dto.TaskRequestDTO;
import com.alexandre.todolist.dto.TaskResponseDTO;
import com.alexandre.todolist.dto.TaskUpdateRequestDTO;
import com.alexandre.todolist.entity.Task;

public class TaskMapper {

    // Converte o DTO de criação para a Entity
    public static Task toEntity(TaskRequestDTO dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setPriority(dto.getPriority());
        return task;
    };

    // Converte a Entity para o DTO de resposta
    public static TaskResponseDTO toResponse(Task task){
        TaskResponseDTO response = new TaskResponseDTO();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setCompleted(task.isCompleted());
        response.setDueDate(task.getDueDate());
        response.setCreatedAt(task.getCreatedAt());
        response.setPriority(task.getPriority());
        return response;
    }

    // Método para aplicar as atualizações do UpdateDTO na Entity existente
    public static void updateEntityFromDto(TaskUpdateRequestDTO dto, Task task){
        if (dto.getTitle() != null){
            task.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null){
            task.setDescription(dto.getDescription());
        }
        if (dto.getDueDate() != null) {
            task.setDueDate(dto.getDueDate());
        }
        if (dto.getCompleted() != null) {
            task.setCompleted(dto.getCompleted());
        }
        if (dto.getPriority() != null){
            task.setPriority(dto.getPriority());
        }
    };
}
