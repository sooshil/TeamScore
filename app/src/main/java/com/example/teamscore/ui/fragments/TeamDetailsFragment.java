package com.example.teamscore.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamscore.R;
import com.example.teamscore.model.Results;
import com.example.teamscore.model.Teams;
import com.example.teamscore.model.UpcomingResults;
import com.example.teamscore.network.RetrofitInstance;
import com.example.teamscore.network.TeamsAPIInterface;
import com.example.teamscore.ui.activity.MainActivity;
import com.example.teamscore.ui.adapters.RecentMatchAdapter;
import com.example.teamscore.ui.adapters.TeamAdapter;
import com.example.teamscore.ui.adapters.UpcomingMatchAdapter;
import com.example.teamscore.viewModel.TeamsViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailsFragment extends Fragment {

    private TeamsViewModel teamsViewModel;
    private Teams.Team savedTeam;
    private ImageView searchIcon;
    private TextView textViewTeamName, textViewLeague, textViewSportsName;
    private ImageView teamLogo;
    private TeamsAPIInterface teamsAPIInterface;
    private String searchedTeam;
    private RecentMatchAdapter recentMatchAdapter;
    private UpcomingMatchAdapter upcomingMatchAdapter;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewUpcoming;
    private MainActivity activity;
    private String userTeam = "savedTeamID";

    public TeamDetailsFragment() {
        // Required empty public constructor
    }


    public static TeamDetailsFragment newInstance(String param1, String param2) {
        TeamDetailsFragment fragment = new TeamDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team_details, container, false);
        searchIcon = view.findViewById(R.id.search_icon);
        textViewTeamName = view.findViewById(R.id.textViewTeamName);
        textViewLeague = view.findViewById(R.id.textViewLeague);
        textViewSportsName = view.findViewById(R.id.textViewSportsName);
        teamLogo = view.findViewById(R.id.imageViewTeamLogo);
//        textViewEventDate = view.findViewById(R.id.textViewEventDate);
//        textViewHomeTeam = view.findViewById(R.id.textViewHomeTeam);
//        textViewAwayTeam = view.findViewById(R.id.textViewAwayTeam);
//        textViewHomeScore = view.findViewById(R.id.textViewHomeScore);
//        textViewAwayScore = view.findViewById(R.id.textViewAwayScore);
        recyclerView = view.findViewById(R.id.recycler_recent);
        recyclerViewUpcoming = view.findViewById(R.id.recycler_upcoming);

        searchedTeam = ((MainActivity) getActivity()).userSelectedTeam;
        if(searchedTeam == null) {
            SharedPreferences prefs = getContext().getSharedPreferences("TeamScoreApp", Context.MODE_PRIVATE);
            searchedTeam = prefs.getString(userTeam, null);
        }
        activity = ((MainActivity) getContext());
        activity.toolbar.setTitle("Team Details");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);

        teamsViewModel = new ViewModelProvider(getActivity()).get(TeamsViewModel.class);
        savedTeam = teamsViewModel.getTeams().getValue();
        if(savedTeam == null) {
            recallAPI();
        } else {
            displayUI(savedTeam);
        }

        callRecentMatchesAPI();
        callUpcomingMatchesAPI();

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToSearch();
            }
        });
        return view;
    }

    private void displayUI(Teams.Team team) {
        textViewTeamName.setText(team.getStrTeam());
        textViewLeague.setText("League: " + team.getStrLeague());
        textViewSportsName.setText("Sports: " + team.getStrSport());

        String imageUrl = team.getStrTeamBadge();
        if(imageUrl != null) {
            Picasso.get().load(imageUrl).into(teamLogo);
        }
    }

    private void goBackToSearch() {
        SearchFragment searchFragment = new SearchFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, searchFragment);
        fragmentTransaction
                .addToBackStack("detail_view")
                .commit();
    }

    private void recallAPI() {

        teamsAPIInterface = RetrofitInstance.getRetrofitInstance().create(TeamsAPIInterface.class);
        Call<Teams> call = teamsAPIInterface.getTeam(searchedTeam);
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                if(response.body() != null) {
                    Teams.Team team = response.body().getTeams().get(0);
                    displayUI(team);
                }
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {
                Toast.makeText(getContext(),"Error occured. Data couldn't be load. " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callRecentMatchesAPI() {
        teamsAPIInterface = RetrofitInstance.getRetrofitInstance().create(TeamsAPIInterface.class);
        Call<Results> call = teamsAPIInterface.getReults(searchedTeam);
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if(response.body() != null) {
                    Results event = response.body();
                    generateRecentMatchList(event);
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getContext(),"Error occured. Data couldn't be load. " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callUpcomingMatchesAPI() {
        teamsAPIInterface = RetrofitInstance.getRetrofitInstance().create(TeamsAPIInterface.class);
        Call<UpcomingResults> call = teamsAPIInterface.getUpcomingReults(searchedTeam);
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<UpcomingResults>() {
            @Override
            public void onResponse(Call<UpcomingResults> call, Response<UpcomingResults> response) {
                if(response.body() != null) {
                    UpcomingResults upcomingEvent = response.body();
                    generateUpcomingMatchList(upcomingEvent);
                }
            }

            @Override
            public void onFailure(Call<UpcomingResults> call, Throwable t) {
                Toast.makeText(getContext(),"Error occured. Data couldn't be load. " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateRecentMatchList(Results eventList) {
        recentMatchAdapter = new RecentMatchAdapter(eventList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recentMatchAdapter);
    }

    private void generateUpcomingMatchList(UpcomingResults upcomingEventList) {
        upcomingMatchAdapter = new UpcomingMatchAdapter(upcomingEventList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewUpcoming.setLayoutManager(layoutManager);
        recyclerViewUpcoming.setAdapter(upcomingMatchAdapter);
    }
}