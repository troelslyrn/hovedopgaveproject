package com.app.andel.andelsapp.Viewmap;

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
import com.app.andel.andelsapp.Controller.MyApolloClient;
import com.app.andel.andelsapp.Model.Aktivity;
import com.app.andel.andelsapp.Model.Point;
import com.app.andel.andelsapp.R;
import com.app.andel.andelsapp.appolloQueries.GetAllActivitiesQuery;
import com.app.andel.andelsapp.appolloQueries.GetAllPointsQuery;

import java.util.ArrayList;

import javax.annotation.Nonnull;

public class AktivitetOversigt extends AppCompatActivity {

    ListView AgendaListViewClick;
    private ArrayList<Aktivity>AktivitetPunkterAgenda;
    private ArrayAdapter<Aktivity> adapter;
    private static final String TAG = "AgendaOverpunkt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivitet_oversigt);

        ImageButton home =(ImageButton)findViewById(R.id.HomeButtonAktivitetOversigt);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AktivitetOversigt.this, MainActivity.class));

            }

        });

        AgendaListViewClick = (ListView)findViewById(R.id.ListViewAktivitetOversigt);
        AktivitetPunkterAgenda = new ArrayList<Aktivity>();
        adapter = new ArrayAdapter<Aktivity>(this, android.R.layout.activity_list_item,android.R.id.text1,AktivitetPunkterAgenda);


        }
        private void getAktivitys(){
            MyApolloClient.getMyapolloClient().query(
                    GetAllActivitiesQuery.builder().build()).enqueue(new ApolloCall.Callback<GetAllActivitiesQuery.Data>() {
                @Override
                public void onResponse(@Nonnull Response<GetAllActivitiesQuery.Data> response) {
                    Log.d(TAG,"OnResponse:" + response.data().getActivitys().size());
                    if(response.data().getActivitys().size() > 0) {
                        for (int i = 0; i < response.data().getActivitys().size(); i++) {
                            int aktivityId = Integer.parseInt(response.data().getActivitys().get(i).activity_id());
                            int aktivityFK =Integer.parseInt(response.data().getActivitys().get(i).fk_event_id());
                            String Aktivitytitle = response.data().getActivitys().get(i).title();

                            Aktivity aktivity = new Aktivity(aktivityId,aktivityFK,Aktivitytitle);
                            //henter alle titler på aktivity fra endpoint
                            Bundle bundleAktivi = getIntent().getExtras();
                            int aktiviID = bundleAktivi.getInt("aktivi ID");
                            if (aktiviID == aktivity.getActivity_id()){
                                AktivitetPunkterAgenda.add(aktivity);
                            } else {
                                Log.d(TAG, "could not find any point");
                            }
                        }
                    }
                    AktivitetOversigt.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AgendaListViewClick.setAdapter(adapter);
                            AgendaListViewClick.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                //gør punkterne på listen til "knapper" som når de trykkes på føres man over til en ny aktivitet i dette tilfælde vil det være punkt1
                                //den benytter sig ag positionerne på listen fra 0 til 0< X
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    for (int i = 0;  i < AktivitetPunkterAgenda.size()  ; i++) {
                                        if (position == i){
                                            adapter.getItem(i).getTitle();
                                            Intent punktIntent = new Intent(view.getContext(), AgendaOverpunkt.class);
                                            //Bundle Pointbundle = new Bundle();
                                            //Pointbundle.putInt("PointKey",OverPunkterAgenda.get(i).getPoint_id());
                                            //punktIntent.putExtra("pointkey",Pointbundle);
                                            punktIntent.putExtra("AktivityID",AktivitetPunkterAgenda.get(i).getActivity_id()).toString();
                                            punktIntent.putExtra("Aktivity Title",AktivitetPunkterAgenda.get(i).getTitle());
                                            punktIntent.putExtra("Aktivity FK",AktivitetPunkterAgenda.get(i).getFk_event_id());
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