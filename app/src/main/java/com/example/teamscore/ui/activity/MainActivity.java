package com.example.teamscore.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.teamscore.R;
import com.example.teamscore.model.Teams;
import com.example.teamscore.network.RetrofitInstance;
import com.example.teamscore.network.TeamsAPIInterface;
import com.example.teamscore.ui.adapters.TeamAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TeamAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TeamsAPIInterface teamsAPIInterface = RetrofitInstance.getRetrofitInstance().create(TeamsAPIInterface.class);
        Call<Teams> call = teamsAPIInterface.getTeams();
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                if(response.body() != null) {
                    Toast.makeText(MainActivity.this, "Response was successful", Toast.LENGTH_SHORT).show();
                    String result = response.body().toString();
                }
                Teams teams = response.body();
                generateTeamList(teams);
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error occured" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void generateTeamList(Teams teamLists) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_team_list);

        adapter = new TeamAdapter(teamLists);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

    }
}