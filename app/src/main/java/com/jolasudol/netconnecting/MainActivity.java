package com.jolasudol.netconnecting;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.jolasudol.netconnecting.model.Task;
import com.jolasudol.netconnecting.service.TaskService;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Path;

import static com.jolasudol.netconnecting.TaskMapper.fromTaskDTO;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://shrouded-fjord-81597.herokuapp.com/";
    private ListView listView;
    private Button button;
    private TaskService taskService;
    private TaskArrayAdapter taskArrayAdapter;
    private List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.addButton);
        tasks = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        taskService = retrofit.create(TaskService.class);

        Call<List<TaskDTO>> call = taskService.findAllTaskByUser(9l);
        call.enqueue(new Callback<List<TaskDTO>>() {
            @Override
            public void onResponse(Call<List<TaskDTO>> call, Response<List<TaskDTO>> response) {
                tasks.addAll(fromTaskDTO(response.body()));
            }

            @Override
            public void onFailure(Call<List<TaskDTO>> call, Throwable t) {


            }
        });


//        new Async().execute();
//    }
//
//    private class Async extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//            // The connection URL
//            String url = "https://shrouded-fjord-81597.herokuapp.com/api/task/all/9";
//// Create a new RestTemplate instance
//            RestTemplate restTemplate = new RestTemplate();
//// Add the String message converter
//            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
//// Make the HTTP GET request, marshaling the response to a String
//            TaskDTO result = restTemplate.getForObject(url, TaskDTO.class);
//            return null;
//        }
    }
}