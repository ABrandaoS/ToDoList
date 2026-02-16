package com.alexandre.todolist.mapper;

import com.alexandre.todolist.dto.TaskRequestDTO;
import com.alexandre.todolist.dto.TaskResponseDTO;
import com.alexandre.todolist.dto.TaskUpdateRequestDTO;
import com.alexandre.todolist.entity.Task;
import com.alexandre.todolist.exception.InvalidTitleException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TaskMapper {

    // Converte o DTO de criação para a Entity
    public static Task toEntity(TaskRequestDTO dto){
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate().atOffset(ZoneOffset.UTC));
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
        response.setDueDate(task.getDueDate().toLocalDateTime());
        response.setCreatedAt(task.getCreatedAt().toLocalDateTime());
        response.setPriority(task.getPriority());
        return response;
    }

    // Para aplicar as atualizações do UpdateDTO na Entity existente
    public static void updateEntityFromDto(TaskUpdateRequestDTO dto, Task task){
        if (dto.getTitle() != null){

            // .trim() remove os espaços das bordas.
            // .lenght(0 checa o tamanho real do texto limpo
            String trimmedTitle = dto.getTitle().trim();

            if (trimmedTitle.isEmpty() || trimmedTitle.length() < 5 || trimmedTitle.length() > 100){
                throw new InvalidTitleException("O título deve conter entre 5 e 100 caracteres válidos (não apenas espaços).");
            }
            task.setTitle(trimmedTitle);
        }

        if (dto.getDescription() != null){
            task.setDescription(dto.getDescription());
        }
        if (dto.getDueDate() != null) {
            task.setDueDate(dto.getDueDate().atOffset(ZoneOffset.UTC));
        }
        if (dto.getCompleted() != null) {
            task.setCompleted(dto.getCompleted());
        }
        if (dto.getPriority() != null){
            task.setPriority(dto.getPriority());
        }
    };
}
