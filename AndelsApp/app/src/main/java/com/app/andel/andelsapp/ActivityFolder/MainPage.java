package com.app.andel.andelsapp.ActivityFolder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.app.andel.andelsapp.MainActivity;
import com.app.andel.andelsapp.MyApolloClient;
import com.app.andel.andelsapp.R;
import com.app.andel.andelsapp.appolloQueries.GetActivitiesQuery;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Nonnull;

public class MainPage extends AppCompatActivity {

    private ArrayList<Activity> activityList;
    private ListView activityListView;
    private ArrayAdapter<Activity> adapter;
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        try {
            getActivities();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageButton home = (ImageButton) findViewById(R.id.imageButton3);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this, MainActivity.class));
            }
        });

        activityListView = findViewById(R.id.ActivityListMainPage);
        activityList = new ArrayList<Activity>();

        adapter = new ArrayAdapter<Activity>(this, android.R.layout.activity_list_item, android.R.id.text1, activityList);
    }
    private void getActivities() throws IOException {
        MyApolloClient.getMyapolloClient().query(
                GetActivitiesQuery.builder().build()).enqueue(new ApolloCall.Callback<GetActivitiesQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<GetActivitiesQuery.Data> response) {
                if(response.data().current_team().activities().size() > 0){
                    for (int i = 0; i < response.data().current_team().activities().size() ; i++) {

                        String name = response.data().current_team().activities().get(i).name();
                        String place = response.data().current_team().activities().get(i).place();
                        String startTime = response.data().current_team().activities().get(i).starttime().normal();

                        String username = response.data().current_team().activities().get(i).users_with_no_rsvp().get(i).username();
                        int userid = response.data().current_team().activities().get(i).users_with_no_rsvp().get(i).id();
                        User user = new User(userid, username);


                        Activity activity = new Activity(name, place, startTime);
                        activityList.add(activity);
                    }
                }
                MainPage.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activityListView.setAdapter(adapter);
                        activityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                for (int i = 0; i < activityList.size() ; i++) {
                                    if(position == i){
                                        adapter.getItem(i).getName();
                                        Intent activityIntent = new Intent(view.getContext(), ActivityMeeting.class);
                                        activityIntent.putExtra("nameKEY", activityList.get(i).getName());
                                        activityIntent.putExtra("placeKEY", activityList.get(i).getPlace());
                                        activityIntent.putExtra("timeKEY", activityList.get(i).getStartTime());
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
