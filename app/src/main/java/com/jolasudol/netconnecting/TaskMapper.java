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
        taskDTO.setUser(7);
        taskDTO.setValue(task.getValue());
        return taskDTO;
    }

}
