package com.example.p03_classjournal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstActivityAdapter extends ArrayAdapter {

    private ArrayList<FirstActivityClass> alModule;
    private Context context;
    private TextView tvCode, tvName;

    public FirstActivityAdapter(@NonNull Context context, int resource, @NonNull ArrayList<FirstActivityClass> objects) {
        super(context, resource, objects);

        alModule = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row, parent, false);
        tvName = convertView.findViewById(R.id.textViewModuleName);
        tvCode = convertView.findViewById(R.id.textViewCode);

        FirstActivityClass currentModule = alModule.get(position);

        tvName.setText(currentModule.getName());
        tvCode.setText(currentModule.getCode());

        return convertView;


    }
}
