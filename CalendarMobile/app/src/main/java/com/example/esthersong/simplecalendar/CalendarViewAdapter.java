package com.example.esthersong.simplecalendar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalendarViewAdapter extends BaseAdapter {
    private final int color = Color.parseColor("#EABA9D");
    private Context context;
    private Day[] days;

    public CalendarViewAdapter(Context context, Day[] days) {
        this.context = context;
        this.days = days;
    }
    @Override
    public int getCount() {
        return days.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Day day = days[position];
        final ViewHolder vh;

        if(convertView == null) {
            vh = new ViewHolder();
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.layout_day_cell, parent,false);
            vh.day_tv = convertView.findViewById(R.id.day_tv);
            vh.eventOneTv = convertView.findViewById(R.id.event_one_tv);
            vh.eventTwoTv = convertView.findViewById(R.id.event_two_tv);
            vh.eventThreeTv = convertView.findViewById(R.id.event_three_tv);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.day_tv.setText(Integer.toString(day.getDay()+1));

        vh.eventOneTv.setFilters( new InputFilter[] { new InputFilter.LengthFilter(7) } );
        vh.eventTwoTv.setFilters( new InputFilter[] { new InputFilter.LengthFilter(7) } );
        vh.eventThreeTv.setFilters( new InputFilter[] { new InputFilter.LengthFilter(7) } );


        if(day.getAllEvent().size() == 1){
            vh.eventOneTv.setBackgroundColor(color);
            vh.eventOneTv.setText(day.getAllEvent().get(day.getAllEvent().size()-1).getTitle());
        }
        if(day.getAllEvent().size() == 2){
            vh.eventOneTv.setBackgroundColor(color);
            vh.eventTwoTv.setBackgroundColor(color);

            vh.eventOneTv.setText(day.getAllEvent().get(day.getAllEvent().size()-1).getTitle());
            vh.eventTwoTv.setText(day.getAllEvent().get(day.getAllEvent().size()-2).getTitle());
        }
        if(day.getAllEvent().size() > 2) {
            vh.eventOneTv.setBackgroundColor(color);
            vh.eventTwoTv.setBackgroundColor(color);
            vh.eventThreeTv.setBackgroundColor(color);

            vh.eventOneTv.setText(day.getAllEvent().get(day.getAllEvent().size()-1).getTitle());
            vh.eventTwoTv.setText(day.getAllEvent().get(day.getAllEvent().size()-2).getTitle());
            vh.eventThreeTv.setText(day.getAllEvent().get(day.getAllEvent().size()-3).getTitle());
        }

        LinearLayout daybox = convertView.findViewById(R.id.day_cell_ll);

        daybox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof MainActivity) {
                    ((MainActivity)context).createEvent(position);
                }
            }
        });
        return convertView;
    }

    private class ViewHolder {
        TextView day_tv;
        TextView eventOneTv;
        TextView eventTwoTv;
        TextView eventThreeTv;
    }
}
