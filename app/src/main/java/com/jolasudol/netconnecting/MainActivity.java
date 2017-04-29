package com.jolasudol.netconnecting;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Button;
import android.widget.ListView;

import com.jolasudol.netconnecting.model.Task;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.addButton);
        new Async().execute();

    }

    private class Async extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            // The connection URL
            String url = "https://shrouded-fjord-81597.herokuapp.com/api/task/all/7";
// Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
// Add the String message converter
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
// Make the HTTP GET request, marshaling the response to a String
            TaskDTO result = restTemplate.getForObject(url, TaskDTO.class);

            return null;
        }
    }

}
