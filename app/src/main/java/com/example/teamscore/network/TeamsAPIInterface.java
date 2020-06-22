package com.example.teamscore.network;

import com.example.teamscore.model.Teams;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TeamsAPIInterface {

    @GET("api/v1/json/1/searchteams.php")
    Call<Teams> getTeams(@Query("t") String team);
}
