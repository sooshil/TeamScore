package com.example.teamscore.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamscore.R;
import com.example.teamscore.model.Teams;
import com.example.teamscore.network.RetrofitInstance;
import com.example.teamscore.network.TeamsAPIInterface;
import com.example.teamscore.ui.activity.MainActivity;
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
    TeamsAPIInterface teamsAPIInterface;


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

        teamsViewModel = new ViewModelProvider(getActivity()).get(TeamsViewModel.class);
        savedTeam = teamsViewModel.getTeams().getValue();
        if(savedTeam == null) {
            recallAPI();
        } else {
            displayUI(savedTeam);
        }

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
        fragmentTransaction.commit();
    }

    private void recallAPI() {
        String searchTeam = ((MainActivity) getActivity()).userSelectedTeam;
        TeamsAPIInterface teamsAPIInterface = RetrofitInstance.getRetrofitInstance().create(TeamsAPIInterface.class);
        Call<Teams> call = teamsAPIInterface.getTeam(searchTeam);
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
}