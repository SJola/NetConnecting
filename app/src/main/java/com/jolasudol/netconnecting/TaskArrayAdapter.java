package com.jolasudol.netconnecting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jolasudol.netconnecting.model.Task;

import java.util.List;

/**
 * Created by RENT on 2017-04-29.
 */

public class TaskArrayAdapter extends ArrayAdapter<TaskDTO> {


    public TaskArrayAdapter(Context context, List<TaskDTO> taskList) {
        super(context, 0, taskList);
    }


}
