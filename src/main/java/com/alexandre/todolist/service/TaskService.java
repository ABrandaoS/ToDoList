package com.alexandre.todolist.service;

import com.alexandre.todolist.dto.TaskRequestDTO;
import com.alexandre.todolist.dto.TaskResponseDTO;
import com.alexandre.todolist.dto.TaskUpdateRequestDTO;
import com.alexandre.todolist.entity.Task;
import com.alexandre.todolist.exception.TaskNotFoundException;
import com.alexandre.todolist.mapper.TaskMapper;
import com.alexandre.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public TaskResponseDTO create(TaskRequestDTO dto){
        Task task = TaskMapper.toEntity(dto);
        taskRepository.save(task);
        return TaskMapper.toResponse(task);
    }

    @Transactional(readOnly = true)
    public List<TaskResponseDTO> findAll(){
        return taskRepository.findAll().stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TaskResponseDTO findById(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new TaskNotFoundException("ID da tarefa não encontrado"));
        return TaskMapper.toResponse(task);
    }

    @Transactional
    public TaskResponseDTO update(Long id, TaskUpdateRequestDTO dto){
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new TaskNotFoundException("ID da tarefa não encontrado"));

        TaskMapper.updateEntityFromDto(dto, task);

        return TaskMapper.toResponse(taskRepository.save(task));
    }

    @Transactional
    public void delete(Long id){
        if (!taskRepository.existsById(id)){
            throw new TaskNotFoundException("ID da tarefa não encontrado");
        }
        taskRepository.deleteById(id);
    }
}
