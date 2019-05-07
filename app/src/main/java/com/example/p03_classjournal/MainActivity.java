package com.example.p03_classjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    ListView lvModuleCode;
    ArrayList<FirstActivityClass> alModuleCode;
    ArrayAdapter<String> aaModuleCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvModuleCode = findViewById(R.id.listViewModuleCode);

        alModuleCode = new ArrayList<FirstActivityClass>();
        moduleCodes();
        aaModuleCode = new FirstActivityAdapter(this, R.layout.row, alModuleCode);
        lvModuleCode.setAdapter(aaModuleCode);
        aaModuleCode.notifyDataSetChanged();

        lvModuleCode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("moduleCode", alModuleCode.get(i).getCode());
                intent.putExtra("emailFaci", "andy_tao@rp.edu.sg");
                intent.putExtra("position", adapterView.getPositionForView(view) );
                startActivity(intent);

            }
        });


    }

    void moduleCodes(){
        alModuleCode.add(new FirstActivityClass("C347", "Android Programming II"));
        alModuleCode.add(new FirstActivityClass("C302", "Web Services"));

    }
}
