package com.example.teamscore.network;

import com.example.teamscore.model.Event;
import com.example.teamscore.model.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeamsAPIInterface {

    @GET("api/v1/json/1/lookupteam.php")
    Call<Teams> getTeam(@Query("id") String id);

    @GET("api/v1/json/1/searchteams.php")
    Call<Teams> getTeams(@Query("t") String team);

    //https://www.thesportsdb.com/api/v1/json/1/eventslast.php?id=133602
    @GET("api/v1/json/1/eventslast.php")
    Call<Event> getEvent(@Query("id") String id);
}
