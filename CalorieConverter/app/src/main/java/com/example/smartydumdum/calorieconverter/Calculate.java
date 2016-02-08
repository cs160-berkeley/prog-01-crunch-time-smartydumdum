package com.example.smartydumdum.calorieconverter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculate extends AppCompatActivity implements View.OnClickListener {

    String exercise;
    int amount;
    int cal;
    int pu;
    int su;
    int jj;
    int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Intent intent = getIntent();
        exercise = intent.getStringExtra("com.example.smartydumdum.calorieconverter.exercise");
        amount = intent.getIntExtra("com.example.smartydumdum.calorieconverter.amount", 0);

        calculate(exercise, amount);

        TextView calories = (TextView) findViewById(R.id.calories);
        TextView pushup = (TextView) findViewById(R.id.pushup);
        TextView situp = (TextView) findViewById(R.id.situp);
        TextView jumping_jack = (TextView) findViewById(R.id.jumping_jacks);
        TextView jogging = (TextView) findViewById(R.id.jogging);
        calories.setText(String.valueOf(cal));
        pushup.setText(String.valueOf(pu));
        situp.setText(String.valueOf(su));
        jumping_jack.setText(String.valueOf(jj));
        jogging.setText(String.valueOf(j));

        Button b = (Button) findViewById(R.id.button2);

        b.setOnClickListener(this);
    }

    public void calculate(String e, int a) {
        switch (e) {
            case "pushup": {
                pu = a;
                cal = pu*10/35;
                su = cal*2;
                jj = cal/10;
                j = cal*12/100;
                break;
            }
            case "situp": {
                su = a;
                cal = su/2;
                pu = cal*35/10;
                jj = cal/10;
                j = cal*12/100;
                break;
            }
            case "jumping_jacks": {
                jj = a;
                cal = jj*10;
                pu = cal*35/10;
                su = cal*2;
                j = cal*12/100;
                break;
            }
            case "jogging": {
                j = a;
                cal = j*100/12;
                pu = cal*35/10;
                su = cal*2;
                jj = cal/10;
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Converter.class);
        startActivity(i);
    }
}
