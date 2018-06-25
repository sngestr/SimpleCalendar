package com.example.esthersong.simplecalendar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        Event event = events.get(position);

        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
            convertView = layoutInflater.inflate(R.layout.layout_event_item, parent,false);
            viewHolder.event_title_tv = convertView.findViewById(R.id.event_title_tv);
            viewHolder.event_description_tv = convertView.findViewById(R.id.event_description_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (EventListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.event_title_tv.setText(event.getTitle());
        viewHolder.event_description_tv.setText(event.getDescription());

        return convertView;
    }

    public class ViewHolder {
        TextView event_title_tv;
        TextView event_description_tv;
    }
}
