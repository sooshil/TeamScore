package com.example.teamscore.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamscore.R;
import com.example.teamscore.model.Teams;
import com.example.teamscore.ui.fragments.SearchFragment;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Teams dataList;
    private SearchFragment searchFragment;


    public TeamAdapter(SearchFragment searchFragment, Teams dataList) {
        this.dataList = dataList;
        this.searchFragment = searchFragment;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_layout, parent, false);
        return new TeamViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        if(dataList.getTeams() != null && dataList.getTeams().get(position) != null) {
            if(dataList.getTeams().get(position).getIdTeam() != null) {
                holder.txtTeamID.setText(dataList.getTeams().get(position).getIdTeam());
            }
            if(dataList.getTeams().get(position).getStrTeam() != null) {
                holder.txtTeamName.setText(dataList.getTeams().get(position).getStrTeam());
            }
            if(dataList.getTeams().get(position).getStrSport() != null) {
                holder.txtSportsName.setText(dataList.getTeams().get(position).getStrSport());
            }

            holder.myConstraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    searchFragment.showTeamDetails(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(dataList != null && dataList.getTeams() != null) {
            return dataList.getTeams().size();
        } else {
            // toast is commented because this (adapter) is not right place to keep toast.
            // if this is uncommented, we need to define Context context; and context = FragmentName.getContext() in constructor.
            // Toast.makeText(context, "Team not found", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView txtTeamID, txtSportsName, txtTeamName;
        ConstraintLayout myConstraintLayout;

        TeamViewHolder(View itemView) {
            super(itemView);
            txtTeamID = itemView.findViewById(R.id.txt_team_id);
            txtTeamName = itemView.findViewById(R.id.txt_team_name);
            txtSportsName = itemView.findViewById(R.id.txt_sports_name);
            myConstraintLayout = itemView.findViewById(R.id.team_detail_card);
        }
    }
}
