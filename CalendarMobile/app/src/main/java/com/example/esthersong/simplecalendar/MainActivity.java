package com.example.esthersong.simplecalendar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/*
 *  TODO ---------------------------------------------------------------------------------------
 *  • PUT: When the user click on the event, have a pop up for edit to be shown and then
 *         when the user click submit, you edit the event object and call PUT. Then call
 *         notifyDataChanged.
 *  • DELETE: When the user click on the event and have a pop up for edit to be shown and
 *         click delete. Then the object will be deleted from the arrayList and call DELETE
 *         then notifyDataChanged
 *  TODO ---------------------------------------------------------------------------------------
 */

public class MainActivity extends AppCompatActivity {
    private Day[] days;

    private int cal_year;
    private int cal_month;
    private int cal_day;
    private int position;

    private GridView calendarView;
    private CalendarViewAdapter calendarAdapter;

    private ListView eventsListView;
    private EventListAdapter eventListAdapter;

    private Dialog myDialog; //popup

    private OkHttpClient client = new OkHttpClient();
    private String url = "https://glacial-stream-73172.herokuapp.com/events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Hide Action Bar
        setContentView(R.layout.activity_main);

        // Get current date
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        cal_year = cal.get(Calendar.YEAR);
        cal_month = cal.get(Calendar.MONTH);
        cal_day = cal.get(Calendar.DAY_OF_MONTH);


        // Set current month and year
        int color = Color.parseColor("#EABA9D");
        TextView current_month_year_tv = findViewById(R.id.current_month_year_tv);
        current_month_year_tv.setBackgroundColor(color);
        String month_name = new SimpleDateFormat("MMM").format(cal.getTime());
        current_month_year_tv.setText( month_name + " " + cal_year);

        // Gets the amount of days in the MONTH
        cal = new GregorianCalendar(cal_year, cal_month, cal_day);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        days = new Day[daysInMonth];

        for(int i = 0; i < daysInMonth; i++){
            Day newday = new Day(i);
            days[i] = newday;
        }

        new GETAsyncTask().execute();

        // Dialog
        myDialog = new Dialog(this);

//        ArrayList<Event> test = new ArrayList<>();
//        Event e = new Event(1,2,1993,"yo mo", "hey", "5:00", "6:00");
//        test.add(e);

        // Events ListView
        eventsListView = findViewById(R.id.events_lv);
        eventListAdapter = new EventListAdapter(this, days[cal_day-1].getAllEvent());
        eventsListView.setAdapter(eventListAdapter);

        // Set up grid view
        calendarView = findViewById(R.id.calendarView);
        calendarAdapter = new CalendarViewAdapter(this, days);
        calendarView.setAdapter(calendarAdapter);
    }

    public void createEvent(final int pos){
        myDialog.setContentView(R.layout.popup_create_event); // Set popup layout
        position = pos;
        Button closeButton = myDialog.findViewById(R.id.close_button);
        Button submit = myDialog.findViewById(R.id.submit_button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = myDialog.findViewById(R.id.title_tv);
                EditText startTime = myDialog.findViewById(R.id.startTime_tv);
                EditText endtime = myDialog.findViewById(R.id.endTime_tv);
                EditText description = myDialog.findViewById(R.id.description_tv);

                POSTEvent(position, cal_month, cal_year, title.getText().toString(), startTime.getText().toString(), endtime.getText().toString(), description.getText().toString());
                Event e = new Event(position, cal_month, cal_year, description.getText().toString(), title.getText().toString(), startTime.getText().toString(), endtime.getText().toString());
                days[position].addEvent(e);

                calendarAdapter.notifyDataSetChanged();
                myDialog.dismiss();
            }
        });

        myDialog.setCanceledOnTouchOutside(false);
        myDialog.show();
    }

    public void showDayEvent(int pos) {
        eventListAdapter = new EventListAdapter(this, days[pos].getAllEvent());
        eventsListView.setAdapter(eventListAdapter);
    }

    private class GETAsyncTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException io) {
                return io.toString();
            }
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String myResponse){
            JSONObject events;
            try {
                events = new JSONObject(myResponse);
                JSONArray jArray = events.getJSONArray("events");

                if (jArray != null) {
                    for (int i = 0; i < jArray.length(); i++){
                        JSONObject eventObj = jArray.getJSONObject(i);
                        int eventId = eventObj.getInt("eventId");
                        int day = eventObj.getInt("day");
                        int month = eventObj.getInt("month");
                        int year = eventObj.getInt("year");

                        String description = eventObj.getString("description");
                        String title = eventObj.getString("title");
                        String startTime = eventObj.getString("startTime");
                        String endTime = eventObj.getString("endTime");
                        Event e = new Event(day, month, year, description, title, startTime, endTime);
                        days[day-1].addEvent(e);
//                        title.setText(e.getDescription());
                    }
                }
                calendarAdapter.notifyDataSetChanged();
                eventListAdapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     *  HTTP POST REQUEST: Post a new event with OkHttp and get a response of the posted event
     */
    public void POSTEvent(int day, int month, int year, String title, String startTime, String endTime, String description){
        MediaType JSON = MediaType.parse("application/json");
        JSONObject eventData = new JSONObject();

        try {
            eventData.put("day", day + 1); // add one bc based on position of grid view
            eventData.put("month", month);
            eventData.put("year", year);
            eventData.put("description", description);
            eventData.put("title", title);
            eventData.put("startTime", startTime);
            eventData.put("endTime", endTime);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(JSON, eventData.toString());
        Request newReq = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(newReq).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
//                    final String myResponse = response.body().string();
//                    JSONObject newEvent = null;
//                    try {
//                        newEvent = new JSONObject(myResponse);
//                        int eventId = newEvent.getInt("eventId");
//                        int day = newEvent.getInt("day");
//                        int month = newEvent.getInt("month");
//                        int year = newEvent.getInt("year");
//                        String description = newEvent.getString("description");
//
//                        Event e = new Event(day, month, year, description, "database", "5:00", "6:00");
//                        days[day-1].addEvent(e);
//                        cA.notifyDataSetChanged();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
    }
}
