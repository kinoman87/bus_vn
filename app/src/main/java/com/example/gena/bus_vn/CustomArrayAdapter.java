package com.example.gena.bus_vn;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String>
{
    private final Context context;
    private final String[] Hours;
    private final String[] Minutes;

    public CustomArrayAdapter(Context context, String[] hours,String[] minutes)
    {
        super(context, R.layout.list_item, hours);
        this.context = context;
        this.Hours = hours;
        this.Minutes=minutes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        TextView textView2 = (TextView) rowView.findViewById(R.id.label2);

        textView2.setText(Hours[position]);
        //textView2.setText();
        String st = "";
        for(int i = 0; i < Minutes.length; i++)
        {
            st=st+" "+Minutes[i];
        }
        textView.setText(st);
        if((position%2)==0)
        {
            rowView.setBackgroundColor(Color.parseColor("#9ac900"));
        }
        else
        {
        }

        return rowView;
    }



}