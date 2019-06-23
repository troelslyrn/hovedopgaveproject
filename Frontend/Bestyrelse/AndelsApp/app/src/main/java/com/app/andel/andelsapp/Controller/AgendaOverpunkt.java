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
import com.app.andel.andelsapp.Model.Point;
import com.app.andel.andelsapp.Model.MyApolloClient;
import com.app.andel.andelsapp.appolloQueries.GetAllPointsQuery;
import com.app.andel.andelsapp.R;

import java.util.ArrayList;

import javax.annotation.Nonnull;

public class AgendaOverpunkt extends AppCompatActivity {
ListView AgendaListViewClick;
private static final String TAG = "AgendaOverpunkt";
private ArrayList<Point>OverPunkterAgenda;
private ArrayAdapter<Point> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afholdse_af_agenda2);
        getPosts();

        ImageButton home =(ImageButton)findViewById(R.id.imageButtonHomeAfholdseAfAgenda2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgendaOverpunkt.this, MainActivity.class));
            }
        });

        AgendaListViewClick = (ListView)findViewById(R.id.AgendaListView);
        OverPunkterAgenda = new ArrayList<Point>();
        adapter = new ArrayAdapter<Point>(this, android.R.layout.activity_list_item,android.R.id.text1,OverPunkterAgenda);
    }

    private void getPosts(){
        MyApolloClient.getMyapolloClient().query(
                GetAllPointsQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllPointsQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<GetAllPointsQuery.Data> response) {
                Log.d(TAG,"OnResponse:" + response.data().getPoints().size());
                if(response.data().getPoints().size() > 0) {
                    for (int i = 0; i < response.data().getPoints().size(); i++) {
                       int point_id = Integer.parseInt(response.data().getPoints().get(i).point_id());
                       String title = response.data().getPoints().get(i).title();
                       int fk_activity_id = Integer.parseInt(response.data().getPoints().get(i).fk_activity_id());
                       Point point = new Point(point_id, title, fk_activity_id);
                       //henter alle titler på overpunkter fra endpoint
                       Bundle activitybundle = getIntent().getExtras();
                       int activity_id = activitybundle.getInt("ActivityID");
                       if (activity_id == point.getFk_activity_id()){
                           OverPunkterAgenda.add(point);
                       } else {
                           Log.d(TAG, "could not find any point");
                       }
                    }
                }
                AgendaOverpunkt.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AgendaListViewClick.setAdapter(adapter);
                        AgendaListViewClick.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            //gør punkterne på listen til "knapper" som når de trykkes på føres man over til en ny aktivitet i dette tilfælde vil det være punkt1
                            //den benytter sig ag positionerne på listen fra 0 til 0< X
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 0;  i < OverPunkterAgenda.size()  ; i++) {
                                    if (position == i){
                                        adapter.getItem(i).getTitle();
                                        Intent punktIntent = new Intent(view.getContext(), AgendaUnderpunkt.class);
                                        punktIntent.putExtra("Point ID",OverPunkterAgenda.get(i).getPoint_id()).toString();
                                        punktIntent.putExtra("Point Title",OverPunkterAgenda.get(i).getTitle());
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

