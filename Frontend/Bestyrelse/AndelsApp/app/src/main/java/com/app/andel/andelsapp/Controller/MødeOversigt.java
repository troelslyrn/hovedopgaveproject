package com.app.andel.andelsapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.app.andel.andelsapp.Model.MyApolloClient;
import com.app.andel.andelsapp.Model.Event;
import com.app.andel.andelsapp.R;
import com.app.andel.andelsapp.appolloQueries.GetallpostsqueriesQuery;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class MødeOversigt extends AppCompatActivity {
    ListView MeetingListView;
    private static final String TAG = "AgendaOverpunkt";
    private ArrayList<Event> MeetingArrayList;
    private ArrayAdapter<Event> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meetings);
        getEvents();

        ImageButton home = (ImageButton) findViewById(R.id.homeButtonMeeting);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MødeOversigt.this, MainActivity.class));
            }
        });

        MeetingListView = (ListView) findViewById(R.id.MeetingList);
        MeetingArrayList = new ArrayList<Event>();
        adapter = new ArrayAdapter<Event>(this, android.R.layout.activity_list_item, android.R.id.text1, MeetingArrayList);

    }

    private void getEvents() {
        //henter alle møder ud fra ved brug af vores graphql query
        MyApolloClient.getMyapolloClient().query(GetallpostsqueriesQuery.builder().build()).enqueue(new ApolloCall.Callback<GetallpostsqueriesQuery.Data>(){

            @Override
            public void onResponse(@Nonnull Response<GetallpostsqueriesQuery.Data> response) {
                Log.d(TAG,"OnResponse:" + response.data().getEvents().size());
                if(response.data().getEvents().size() > 0) {
                    for (int i = 0; i < response.data().getEvents().size(); i++) {
                        int event_id = Integer.parseInt(response.data().getEvents().get(i).event_id());
                        String title = response.data().getEvents().get(i).title();
                        String startTime = response.data().getEvents().get(i).timeStart();
                        String endTime = response.data().getEvents().get(i).timeEnd();
                        int fk_user_id = Integer.parseInt(response.data().getEvents().get(i).fk_user_id());
                        Event event = new Event(event_id, title, endTime, startTime, fk_user_id);
                        MeetingArrayList.add(event);
                    }
                }
                MødeOversigt.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MeetingListView.setAdapter(adapter);
                        MeetingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            //gør punkterne på listen til "knapper" som når de trykkes på føres man over til en ny aktivitet i dette tilfælde vil det være det afholdelseafagenda2
                            //den benytter sig af positionerne på listen fra 0 til 0< X
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 0;  i < MeetingArrayList.size()  ; i++) {
                                    if (position == i){
                                        adapter.getItem(i).getTitle();
                                       Intent punktIntent = new Intent(view.getContext(), AktivitetOversigt.class);
                                        punktIntent.putExtra("Meeting ID",MeetingArrayList.get(i).getEvent_id());
                                        punktIntent.putExtra("meeting Title",MeetingArrayList.get(i).getTitle());
                                        startActivityForResult(punktIntent,0);
                                    }
                                }
                            }
                        });
                    }
                });
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {

            }
        });
    }
}






