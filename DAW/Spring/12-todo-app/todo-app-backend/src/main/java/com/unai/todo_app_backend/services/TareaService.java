package com.unai.todo_app_backend.services;

import com.unai.todo_app_backend.entities.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaService {
    List<Tarea> getAllTareas();

    Optional<Tarea> getTareasById(Long id);

    Tarea createTarea(Tarea tarea);

    Tarea updateTarea(Long id, Tarea tarea);

    void deleteTarea(Long id);
}
