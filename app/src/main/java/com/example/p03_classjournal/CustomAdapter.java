package com.example.p03_classjournal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    private ArrayList<DailyGrade> alDailyGrade;
    private Context context;
    private TextView tvWeek, tvGrade;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DailyGrade> objects) {
        super(context, resource, objects);

        alDailyGrade = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_list_view, parent, false);
        tvWeek = convertView.findViewById(R.id.textViewWeek);
        tvGrade = convertView.findViewById(R.id.textViewDailyGrade);

        DailyGrade currentGrade = alDailyGrade.get(position);

        tvWeek.setText(currentGrade.getWeek());
        tvGrade.setText(currentGrade.getGrade());

        return convertView;


    }


}
