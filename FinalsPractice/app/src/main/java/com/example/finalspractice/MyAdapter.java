package com.example.finalspractice;

import static android.content.Context.*;
//import static androidx.core.app.AppOpsManagerCompat.Api23Impl.getSystemService;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter {

    LayoutInflater layoutInflater;
    public MyAdapter(@NonNull Context context, int resource, ArrayList arrayList) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
////        LayoutInflater inf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.my_adapter_resource, parent, false);
//        TextView text1 = view.findViewById(R.id.textMain);
//
//
//        return v;
    }
}
