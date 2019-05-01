package com.app.andel.andelsapp.AgendaMappe.PunktMappe;
/*

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.andel.andelsapp.AgendaMappe.Point;
import com.app.andel.andelsapp.appolloQueries.GetSubPointsByPointsIdQuery;
import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.app.andel.andelsapp.AgendaMappe.SubPoint;
import com.app.andel.andelsapp.MainActivity;
import com.app.andel.andelsapp.MyApolloClient;
import com.app.andel.andelsapp.R;


import java.util.ArrayList;

import javax.annotation.Nonnull;
public class Punkt1 extends AppCompatActivity {

    //String pointIdCar= getIntent().getStringExtra("Point ID");
    //String pointIdTitle= getIntent().getStringExtra("Point Title");

    private static final String TAG = "punkt1";
    private static final String TAG1 ="punk1 Id tag";
    ListView subpointAgendaList;
    ArrayAdapter<SubPoint> adapter;
    ArrayList<SubPoint> subPointsList;

    ArrayList<Point>  pointList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punkt1);

        //henter Data fra AfholdAgenda2 gennem bundel, denne data er point id
        Bundle bundleid = getIntent().getExtras();
        String pointid = bundleid.getString("Point ID");

        Bundle bundletitle = getIntent().getExtras();
        String pointtitle = bundletitle.getString("Point Title");
        TextView textViewtest1 = (TextView) findViewById(R.id.PointIdView);
        TextView textViewtest2 = (TextView) findViewById(R.id.PointTitleView);
        textViewtest1.setText(pointid);
        textViewtest2.setText(pointtitle);

       // String pointIdCar= getIntent().getStringExtra("Point ID");
       // String pointIdTitle= getIntent().getStringExtra("Point Title");

        getPosts1();
        ImageButton home = (ImageButton) findViewById(R.id.imageButtonHomePunkt1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Punkt1.this, MainActivity.class));
            }
        });
        subPointsList = new ArrayList<SubPoint>();
        //pointList = new ArrayList<Point>();
       // pointIdCarsList.add(pointIdCar);
        subpointAgendaList = (ListView) findViewById(R.id.Punkt1AgendaListView);
        adapter = new ArrayAdapter<SubPoint>(this, android.R.layout.activity_list_item, android.R.id.text1, subPointsList);
       // adapter1 = new ArrayAdapter<Point>(this,android.R.layout.activity_list_item, android.R.id.text1,pointIdCarsList);

    }

    private void getPosts1(){
        MyApolloClient.getMyapolloClient().query(
                GetSubPointsByPointsIdQuery.builder().build()).enqueue(new ApolloCall.Callback<GetSubPointsByPointsIdQuery.Data>() {

            @Override
            public void onResponse(@Nonnull Response<GetSubPointsByPointsIdQuery.Data> response) {
                Log.d(TAG,"OnResponse:" + response.data().getSubpoints().size());
               // Log.d(TAG1,"OnResponse" + response.data());
                if(response.data().getSubpoints().size() > 0) {
                    for (int i = 0; i < response.data().getSubpoints().size(); i++) {
                        //henter alle titler på overpunkter fra endpoint
                        int subpoint_id = Integer.parseInt(response.data().getSubpoints().get(i).subpoints_id());
                        String title = response.data().getSubpoints().get(i).title();
                        int fk_points_id = Integer.parseInt(response.data().getSubpoints().get(i).fk_points_id());
                        SubPoint subpoint = new SubPoint(subpoint_id, title, fk_points_id);

                        Bundle bundleid = getIntent().getExtras();
                        int pointid = bundleid.getInt("Point ID");
                        if(pointid == subpoint.getFk_points_id()){
                        subPointsList.add(subpoint);
                        }else{
                            Log.d(TAG1, "could not find any subpoints");
                           // Toast.makeText(getBaseContext(),"Could not find any subpoints for this point",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                Punkt1.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        subpointAgendaList.setAdapter(adapter);
                        subpointAgendaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            //gør punkterne på listen til "knapper" som når de trykkes på føres man over til en ny aktivitet i dette tilfælde vil det være punkt1
                            //den benytter sig ag positionerne på listen fra 0 til 0< X
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 0;  i < subPointsList.size()  ; i++) {
                                    if (position == i){
                                            adapter.getItem(i).getTitle();
                                            Intent punktIntent = new Intent(view.getContext(), Punkt2.class);
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
*/
