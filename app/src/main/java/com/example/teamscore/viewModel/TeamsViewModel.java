package com.example.teamscore.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.teamscore.model.Results;
import com.example.teamscore.model.Teams;

public class TeamsViewModel extends ViewModel {

    private MutableLiveData<Teams.Team> team = new MutableLiveData<>();
    private MutableLiveData<Results.Event> event = new MutableLiveData<>();

    public MutableLiveData<Teams.Team> getTeams() {
        return team;
    }

    public void setTeams(Teams.Team teamName) {
        team.setValue(teamName);
    }

}
