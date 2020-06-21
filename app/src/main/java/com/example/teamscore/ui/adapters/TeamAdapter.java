package com.example.teamscore.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.teamscore.R;
import com.example.teamscore.model.Teams;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private Teams dataList;

    public TeamAdapter(Teams dataList) {
        this.dataList = dataList;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_layout, parent, false);
        return new TeamViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        holder.txtTeamID.setText(dataList.getTeams().get(position).getIdTeam());
        holder.txtTeamName.setText(dataList.getTeams().get(position).getStrTeam());
        holder.txtSportsName.setText(dataList.getTeams().get(position).getStrSport());
    }

    @Override
    public int getItemCount() {
        return dataList.getTeams().size();
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView txtTeamID, txtSportsName, txtTeamName;

        TeamViewHolder(View itemView) {
            super(itemView);
            txtTeamID = (TextView) itemView.findViewById(R.id.txt_team_id);
            txtTeamName = (TextView) itemView.findViewById(R.id.txt_team_name);
            txtSportsName = (TextView) itemView.findViewById(R.id.txt_sports_name);
        }
    }
}
