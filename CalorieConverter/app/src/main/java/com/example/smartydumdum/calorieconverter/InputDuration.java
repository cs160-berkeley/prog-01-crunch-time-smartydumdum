package com.example.smartydumdum.calorieconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputDuration extends AppCompatActivity implements View.OnClickListener {

    String exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_duration);

        Intent intent = getIntent();
        exercise = intent.getStringExtra("com.example.smartydumdum.calorieconverter.exercise");

        String units = "reps";

        if (exercise.equals("jogging") || exercise.equals("jumping_jacks")) {
            units = "min";
        }

        Button b = (Button) findViewById(R.id.convert);

        b.setOnClickListener(this);

        TextView textView = (TextView) findViewById(R.id.units);
        textView.setText(units);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Calculate.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        int amount = Integer.parseInt(editText.getText().toString());
        i.putExtra("com.example.smartydumdum.calorieconverter.amount", amount);
        i.putExtra("com.example.smartydumdum.calorieconverter.exercise", exercise);
        startActivity(i);
    }
}
