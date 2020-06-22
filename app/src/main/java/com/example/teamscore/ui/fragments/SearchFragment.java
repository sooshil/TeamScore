package com.example.teamscore.ui.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.teamscore.R;
import com.example.teamscore.model.Teams;
import com.example.teamscore.network.RetrofitInstance;
import com.example.teamscore.network.TeamsAPIInterface;
import com.example.teamscore.ui.adapters.TeamAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

    private EditText editTextSearch;
    private Button btnSearch;
    private TeamAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressBar progressbar;

    public SearchFragment() {
        // Required empty public constructor
    }


    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        View view = inflater.inflate(R.layout.fragment_search,container,false);

        editTextSearch = view.findViewById(R.id.editTextSearch);
        btnSearch = view.findViewById(R.id.btnSearch);
        recyclerView = view.findViewById(R.id.recycler_view_team_list);
        progressbar = view.findViewById(R.id.my_progressbar);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressbar.setVisibility(View.VISIBLE);
                searchTeams(editTextSearch.getText().toString());
            }
        });
        return view;
    }

    public void showTeamDetails(int position) {

        TeamDetailsFragment teamDetailsFragment = new TeamDetailsFragment();
        androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, teamDetailsFragment);
        fragmentTransaction.commit();
    }

    private void generateTeamList(Teams teamLists) {
        adapter = new TeamAdapter(this, teamLists);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void searchTeams(String searchTeam) {
        if(searchTeam == null || searchTeam.equals("")) {
            Toast.makeText(getContext(), "Please enter search term", Toast.LENGTH_SHORT).show();
            progressbar.setVisibility(View.GONE);
            return;
        }
        TeamsAPIInterface teamsAPIInterface = RetrofitInstance.getRetrofitInstance().create(TeamsAPIInterface.class);
        Call<Teams> call = teamsAPIInterface.getTeams(searchTeam);
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                progressbar.setVisibility(View.GONE);
                if(response.body() != null) {
                    Teams teams = response.body();
                    generateTeamList(teams);
                }
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {
                progressbar.setVisibility(View.GONE);
                Toast.makeText(getContext(),"Error occured. Data couldn't be load. " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}