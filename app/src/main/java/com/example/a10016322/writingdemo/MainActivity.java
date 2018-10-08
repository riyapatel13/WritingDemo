package com.example.a10016322.writingdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fileName = "myInfo.json";
        String message = "This is a test to write data.";

        try {
            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_WORLD_WRITEABLE));
            writer.write(message);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//api must be lower than 23 - use 16