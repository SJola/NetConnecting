package com.jolasudol.netconnecting;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jolasudol.netconnecting.model.Task;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.lang.String.valueOf;

/**
 * Created by RENT on 2017-04-29.
 */

public class TaskArrayAdapter extends ArrayAdapter<TaskDTO> {

    private TaskDTO current;

    public TaskArrayAdapter(Context context, List<TaskDTO> taskList) {
        super(context, 0, taskList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TaskDTO taskDTO = getItem(position);
        current = taskDTO;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_row, parent, false);
        }

        TextView idNumber = (TextView) convertView.findViewById(R.id.ordinalNumberView);
        idNumber.setText(valueOf(taskDTO.getId()));
        TextView valueText = (TextView) convertView.findViewById(R.id.taskNameView);
        valueText.setText(taskDTO.getValue());
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkboxView);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                new UpdateAsyncTask().execute(taskDTO);
            }
        });


        return convertView;
    }

//    private class UpdateAsyncTask extends AsyncTask<TaskDTO, Void, String> {
//
//        @Override
//        protected String doInBackground(TaskDTO... params) {
//            String url = "https://shrouded-fjord-81597.herokuapp.com/api/task";
//            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<TaskDTO> entity = new HttpEntity<>(params[0], headers);
//            TaskDTO taskDTO = restTemplate.exchange(url, HttpMethod.PUT, entity, TaskDTO.class).getBody();
//            params[0].setCompleted(taskDTO.isCompleted());
//            notifyDataSetChanged();
//            return null;
//        }
//
//    }


}
