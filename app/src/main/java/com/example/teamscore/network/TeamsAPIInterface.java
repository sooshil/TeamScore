package com.example.teamscore.network;

import com.example.teamscore.model.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamsAPIInterface {
    public String teamsSearchTerm = "";
    @GET("searchteams.php?t=Arsenal")
    Call<Teams> getTeams();

//    @GET("searchteams.php?t={search_term}")
//    Call<Teams> getTeamdetails(@Path("search_term") String search_term);
}
