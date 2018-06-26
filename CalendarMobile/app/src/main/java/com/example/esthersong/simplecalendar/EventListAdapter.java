package com.example.esthersong.simplecalendar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EventListAdapter extends BaseAdapter {
    private ArrayList<Event> events;
    private Context context;

    public EventListAdapter(Context context, ArrayList<Event> events){
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
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
        ViewHolder viewHolder;

        final Event event = events.get(position);

        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.layout_event_item, parent,false);
            viewHolder.event_title_tv = convertView.findViewById(R.id.event_title_tv);
            viewHolder.event_description_tv = convertView.findViewById(R.id.event_description_tv);
            viewHolder.startTime_tv = convertView.findViewById(R.id.event_start_time_tv);
            viewHolder.endTime_tv = convertView.findViewById(R.id.event_end_time_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (EventListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.event_title_tv.setText(event.getTitle());
        viewHolder.startTime_tv.setText(event.getStartTime());
        viewHolder.endTime_tv.setText(event.getEndTime());
        viewHolder.event_description_tv.setText(event.getDescription());

        LinearLayout event_list_ll = convertView.findViewById(R.id.event_list_ll);
        event_list_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof MainActivity) {
                    ((MainActivity)context).editEvent(events, position);
                }
            }
        });

        return convertView;
    }

    public class ViewHolder {
        TextView event_title_tv;
        TextView event_description_tv;
        TextView startTime_tv;
        TextView endTime_tv;
    }
}
