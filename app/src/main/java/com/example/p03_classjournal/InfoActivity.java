package com.example.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    ListView lvDailyGrade;
    Button btnInfo, btnAdd, btnEmail;
    ArrayList<DailyGrade> alDailyGrade;
    ArrayAdapter aaDailyGrade;
    String module_code;
    String emailFaci;
    int requestCodeModule = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        final Intent intent = getIntent();
        module_code = intent.getStringExtra("moduleCode");
        emailFaci = intent.getStringExtra("emailFaci");
        int position = intent.getIntExtra("position",0);
        setTitle("Info for " + module_code);

        lvDailyGrade = findViewById(R.id.listViewInfo);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        alDailyGrade = new ArrayList<DailyGrade>();
        switch (position){
            case 0:
                dailyGradeC347();
                break;
            case 1:
                dailyGradeC302();
                break;
        }



        aaDailyGrade = new CustomAdapter(this, R.layout.custom_list_view, alDailyGrade);
        lvDailyGrade.setAdapter(aaDailyGrade);
        aaDailyGrade.notifyDataSetChanged();

        final int alSize = lvDailyGrade.getCount() + 1;



        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(intent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "Hi Faci, \n\n I am Nana \n\n Please see my remarks so far, Thank you!";
                for(int i = 0; i < alDailyGrade.size(); i++){
                    if(alDailyGrade.get(i).getModule_code().equals(module_code)){
                        message += alDailyGrade.get(i).getWeek() + ": DG : " + alDailyGrade.get(i).getGrade() + "\n";
                    }
                }
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailFaci});
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an email client: "));

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, AddActicity.class);
                intent.putExtra("currentWeek", alSize);
                startActivityForResult(intent, requestCodeModule);
            }
        });

    }

    void dailyGradeC347(){

        alDailyGrade.add(new DailyGrade("week 1", "B", module_code));
        alDailyGrade.add(new DailyGrade("week 2", "C", module_code));
        alDailyGrade.add(new DailyGrade("week 3", "A", module_code));
    }

    void dailyGradeC302(){

        alDailyGrade.add(new DailyGrade("week 1", "A", module_code));
        alDailyGrade.add(new DailyGrade("week 2", "A", module_code));
        alDailyGrade.add(new DailyGrade("week 3", "A", module_code));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(data != null){
                DailyGrade grades = (DailyGrade) data.getSerializableExtra("grades");
                String statement = "";

                if(requestCode == requestCodeModule){
                    alDailyGrade.add(grades);
                    aaDailyGrade.notifyDataSetChanged();
                }
            }
        }
    }


}
