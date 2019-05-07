package com.example.p03_classjournal;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class AddActicity extends AppCompatActivity {
    TextView tvWeek;
    RadioGroup rg;
    RadioButton rb;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_acticity);
        tvWeek = findViewById(R.id.textViewAddWeek);
        rg = findViewById(R.id.rg);
        btnSubmit = findViewById(R.id.buttonSubmit);

        final Intent intent = getIntent();
        final int currentWeek = intent.getIntExtra("currentWeek", 0);
        tvWeek.setText("Week " + currentWeek);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                rb = findViewById(selectedButtonId);
                String currentGrades = "";

                if(rb.getText().toString().equals("A")){
                    currentGrades = "A";
                }else if(rb.getText().toString().equals("B")){
                    currentGrades = "B";
                }else if(rb.getText().toString().equals("C")){
                    currentGrades = "C";
                }else if(rb.getText().toString().equals("D")){
                    currentGrades = "D";
                }else if(rb.getText().toString().equals("F")){
                    currentGrades = "F";
                }else{
                    currentGrades = "X";
                }

                DailyGrade grade = new DailyGrade("week " + Integer.toString(currentWeek), currentGrades, intent.getStringExtra("module_code"));
                Intent i = new Intent();
                i.putExtra("grades", grade);
                setResult(RESULT_OK, i);
                finish();
            }
        });



    }


}
