package com.example.smartydumdum.calorieconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Converter extends AppCompatActivity implements View.OnClickListener {

    Button pushup, situp, jumping_jacks, jogging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        pushup = (Button) findViewById(R.id.pushup);
        situp = (Button) findViewById(R.id.situp);
        jumping_jacks = (Button) findViewById(R.id.jumping_jacks);
        jogging = (Button) findViewById(R.id.jogging);

        pushup.setOnClickListener(this);
        situp.setOnClickListener(this);
        jumping_jacks.setOnClickListener(this);
        jogging.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, InputDuration.class);
        String exercise = "";
        switch (v.getId()) {
            case R.id.pushup: {
                exercise = "pushup";
                break;
            }
            case R.id.situp: {
                exercise = "situp";
                break;
            }
            case R.id.jumping_jacks: {
                exercise = "jumping_jacks";
                break;
            }
            case R.id.jogging: {
                exercise = "jogging";
            }
        }
        intent.putExtra("com.example.smartydumdum.calorieconverter.exercise", exercise);
        startActivity(intent);
    }
}
