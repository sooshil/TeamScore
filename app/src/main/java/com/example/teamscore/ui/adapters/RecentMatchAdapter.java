package com.example.teamscore.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamscore.R;
import com.example.teamscore.model.Results;

public class RecentMatchAdapter extends RecyclerView.Adapter<RecentMatchAdapter.RecentMatchViewHolder> {

    private Results results;

    public RecentMatchAdapter(Results results) {
        this.results = results;
    }

    @NonNull
    @Override
    public RecentMatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_recent_layout, parent, false);
        return new RecentMatchAdapter.RecentMatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentMatchAdapter.RecentMatchViewHolder holder, int position) {
        holder.textViewEventDate.setText(results.getResults().get(position).getDateEvent());
        holder.textViewHomeTeam.setText(results.getResults().get(position).getStrHomeTeam());
        holder.textViewHomeScore.setText(results.getResults().get(position).getIntHomeScore());
        holder.textViewAwayTeam.setText(results.getResults().get(position).getStrAwayTeam());
        holder.textViewAwayScore.setText(results.getResults().get(position).getIntAwayScore());
    }

    @Override
    public int getItemCount() {
        if(results != null && results.getResults() != null) {
            return results.getResults().size();
        }
        return 0;
    }

    class RecentMatchViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewEventDate, textViewHomeTeam, textViewHomeScore, textViewAwayTeam, textViewAwayScore;
        RecentMatchViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewEventDate = itemView.findViewById(R.id.textViewEventDate);
            textViewHomeTeam = itemView.findViewById(R.id.textViewHomeTeam);
            textViewHomeScore = itemView.findViewById(R.id.textViewHomeScore);
            textViewAwayTeam = itemView.findViewById(R.id.textViewAwayTeam);
            textViewAwayScore = itemView.findViewById(R.id.textViewAwayScore);
        }
    }
}
