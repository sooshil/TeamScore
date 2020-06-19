package com.example.teamscore;

import com.google.gson.annotations.SerializedName;

public class TeamDetails {
    @SerializedName("idTeam")
    private String teamID;

    @SerializedName("strTeam")
    private String teamName;

    @SerializedName("strSport")
    private String sportsName;

    @SerializedName("strDescriptionEN")
    private String teamDescription;

    @SerializedName("strCountry")
    private String Country;

    public TeamDetails(String teamID, String teamName, String sportsName, String teamDescription, String country) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.sportsName = sportsName;
        this.teamDescription = teamDescription;
        Country = country;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getSportsName() {
        return sportsName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public String getCountry() {
        return Country;
    }
}
