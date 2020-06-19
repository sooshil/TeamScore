package com.example.teamscore;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamsAPIInterface {
    String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";
    public String teamsSearchTerm = "";

    @GET("searchteams.php?t=" + teamsSearchTerm)
    Call<TeamDetails> getTeamDetails();
}
