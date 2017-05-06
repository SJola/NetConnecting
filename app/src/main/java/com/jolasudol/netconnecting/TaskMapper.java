package com.jolasudol.netconnecting;

import com.jolasudol.netconnecting.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by RENT on 2017-04-29.
 */

public class TaskMapper {
    public static List<TaskDTO> fromTask(List<Task> tasks) {
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task : tasks) {
            taskDTOList.add(fromTask(task));
        }
        return taskDTOList;
    }

    public static TaskDTO fromTask(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setCompleted(task.isCompleted());
        taskDTO.setUser(9);
        taskDTO.setValue(task.getValue());
        return taskDTO;
    }

    public static Task fromTaskDTO(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setCompleted(taskDTO.isCompleted());
        task.setValue(taskDTO.getValue());
        return task;
    }

    public static List<Task> fromTaskDTO(List<TaskDTO> tasks) {
        List<Task> taskList = new ArrayList<>();
        for (TaskDTO task : tasks) {
            taskList.add(fromTaskDTO(task));
        }
        return taskList;
    }
}
