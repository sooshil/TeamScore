package com.example.teamscore.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class TeamList {
    @SerializedName("teams")
    private List<Teams> teamsList;

    public List<Teams> getTeamsList() {
        return teamsList;
    }

    public void setTeamsList(List<Teams> teamsList) {
        this.teamsList = teamsList;
    }
}
