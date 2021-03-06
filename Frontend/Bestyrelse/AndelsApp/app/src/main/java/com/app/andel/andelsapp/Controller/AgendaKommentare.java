package com.app.andel.andelsapp.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.app.andel.andelsapp.Model.SubPoint;
import com.app.andel.andelsapp.Model.MyApolloClient;
import com.app.andel.andelsapp.R;
import com.app.andel.andelsapp.appolloQueries.MakecommentMutation;

import java.util.ArrayList;

import javax.annotation.Nonnull;

public class AgendaKommentare extends AppCompatActivity {
    private static final String TAG = "punkt123";
    ArrayList<SubPoint> ArrayInputList = new ArrayList<>();
    //ListView konklusionsview = findViewById(R.id.Konklusion2);
    ArrayAdapter<String> adapter;
    ArrayList <String> List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punkt2);
        Button savebutton;
        savebutton = findViewById(R.id.SaveNow2);
        final EditText  konklussionsskriver;
        konklussionsskriver = findViewById(R.id.Writer2);

      //  adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, List);
        //Spinner spinner1 = (Spinner)findViewById(R.id.KommentarSpinner);
       // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // spinner1.setAdapter(adapter);



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
                        //KALD addToListView()
                        ArrayAdapter arrayAdapter = new ArrayAdapter<SubPoint>(AgendaKommentare.this, android.R.layout.activity_list_item, ArrayInputList);
                        Log.d(TAG, "efsdsgs" );
                        makeComment();
                      //  Spinner spinner1 = (Spinner)findViewById(R.id.KommentarSpinner);
                       // spinner1.setAdapter(arrayAdapter);

                    }
                }
            }
        });
    }

        private void makeComment(){
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
