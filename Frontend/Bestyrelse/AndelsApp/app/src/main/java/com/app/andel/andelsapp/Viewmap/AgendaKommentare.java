package com.app.andel.andelsapp.Viewmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.app.andel.andelsapp.Controller.SubPoint;
import com.app.andel.andelsapp.Model.MyApolloClient;
import com.app.andel.andelsapp.R;
import com.app.andel.andelsapp.appolloQueries.MakecommentMutation;

import java.util.ArrayList;

import javax.annotation.Nonnull;

public class AgendaKommentare extends AppCompatActivity {
    private static final String TAG = "punkt123";
    //private static final String TAG = "AgendaKommentare";
    ArrayList<SubPoint> ArrayInputList = new ArrayList<>();
   // private   Bundle bundleSub = getIntent().getExtras();
    //private int subId = bundleSub.getInt("subpointID");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punkt2);
        // getPosts();
        Button savebutton;
        //
        ListView listViewkommentar = findViewById(R.id.Konklusion2);
        savebutton = findViewById(R.id.SaveNow2);
        final EditText  konklussionsskriver;
        konklussionsskriver = findViewById(R.id.Writer2);
        final ListView konklusionsview = findViewById(R.id.Konklusion2);
        //SubPoint subPoint = new SubPoint


      //  makecomment();

        Button tilbageknap = findViewById(R.id.BackButtonPunkt2);
        tilbageknap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgendaKommentare.this, AgendaUnderpunkt.class));
            }
        });
        ImageButton menuknap = findViewById(R.id.MenuButtonPunkt2);
        menuknap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AgendaKommentare.this, MainActivity.class));
            }
        });

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getinput = konklussionsskriver.getText().toString();

                if (ArrayInputList.contains(getinput)) {

                    Toast.makeText(getBaseContext(), "Der er allerede nogen der har skrevet denne kommentar", Toast.LENGTH_LONG).show();
                } else {
                    if (getinput == null || getinput.trim().equals("")) {
                        Toast.makeText(getBaseContext(), "Der er ikke registeret noget", Toast.LENGTH_LONG).show();
                    } else {
                        Bundle bundleSub = getIntent().getExtras();
                        int subId = bundleSub.getInt("subpointID");
                        SubPoint subPoint =new SubPoint(subId, getinput);
                        ArrayInputList.add(subPoint);
                        makecomment();
                        // ArrayAdapter<String> inputAdapter = new ArrayAdapter<String>(AgendaKommentare.this, android.R.layout.simple_list_item_1, ArrayInputList);
                        // konklusionsview.setAdapter(inputAdapter);
                    }
                }
            }
        });
    }

        private void makecomment(){

           // EditText konklussionsskriver = (EditText) findViewById(R.id.Writer2);
            for (int i = 0; i < ArrayInputList.size(); i++) {

            MyApolloClient.getMyapolloClient().mutate(
                    MakecommentMutation.builder().data(ArrayInputList.get(i).getMakecomment()).id(String.valueOf(ArrayInputList.get(i).getSubpoints_id()))
                           .build()).enqueue(new ApolloCall.Callback<MakecommentMutation.Data>(){

                @Override
                public void onResponse(@Nonnull Response<MakecommentMutation.Data> response) {
                AgendaKommentare.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"WORKS???:");
                        //Toast.makeText(AgendaKommentare.this, "Added success", Toast.LENGTH_SHORT).show();
                    }
                });
                }

                @Override
                public void onFailure(@Nonnull ApolloException e) {

                }
            });
    }
            }
}
    //ListView konklusionsview = findViewById(R.id.Konklusion2);
//ArrayList<String> arrayListDatabaseoutput = new ArrayList<>();


    /*private void getPosts (){
        MyApolloClient.getMyapolloClient().query(
                GetallpostsqueriesQuery.builder().build()).enqueue(new ApolloCall.Callback<GetallpostsqueriesQuery.Data>() {
            @Override
            public void onResponse(@Nonnull final Response<GetallpostsqueriesQuery.Data> response) {
               // Log.d(TAG,"OnResponse:" + response.data().getEvents().get(0).title());

                AgendaKommentare.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //konklusionsview.(response.data().getEvents().get(0).title());
                    }
                });
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {

            }
        });
    }*/

