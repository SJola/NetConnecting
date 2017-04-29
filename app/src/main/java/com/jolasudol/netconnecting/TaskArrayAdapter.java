package com.jolasudol.netconnecting;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.jolasudol.netconnecting.model.Task;

import java.util.List;

/**
 * Created by RENT on 2017-04-29.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {


    public TaskArrayAdapter(Context context, List<Task> taskList) {
        super(context, 0, taskList);
    }
}
