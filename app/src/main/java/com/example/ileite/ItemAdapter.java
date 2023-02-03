package com.example.ileite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ileite.model.Cow;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Cow> implements View.OnClickListener {

    private ArrayList<Cow> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView nameCow;
        TextView dailyAvarege;
    }

    public ItemAdapter(ArrayList<Cow> data, Context context) {
        super(context, R.layout.item_layout, data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View newView, ViewGroup parent) {
        Cow cowRend = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (newView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            newView = inflater.inflate(R.layout.item_layout_relative, parent, false);
            viewHolder.nameCow = newView.findViewById(R.id.nameCowTxt2);
            viewHolder.dailyAvarege = newView.findViewById(R.id.dailyAvaregeTxt2);

            newView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) newView.getTag();
        }

        lastPosition = position;

        viewHolder.nameCow.setText(cowRend.getName());
        viewHolder.dailyAvarege.setText(cowRend.getAmountMilk() + " Liters");
        return newView;
    }


}
