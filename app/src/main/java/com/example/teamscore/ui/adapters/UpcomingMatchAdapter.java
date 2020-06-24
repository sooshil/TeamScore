package com.example.teamscore.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamscore.R;
import com.example.teamscore.model.Results;
import com.example.teamscore.model.UpcomingResults;

public class UpcomingMatchAdapter extends RecyclerView.Adapter<UpcomingMatchAdapter.UpcomingMatchViewHolder> {

    private UpcomingResults upcomingResults;

    public UpcomingMatchAdapter(UpcomingResults upcomingResults) {
        this.upcomingResults = upcomingResults;
    }

    @NonNull
    @Override
    public UpcomingMatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_upcomming_layout, parent, false);
        return new UpcomingMatchAdapter.UpcomingMatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingMatchAdapter.UpcomingMatchViewHolder holder, int position) {
        holder.textViewEventDate.setText(upcomingResults.getUpcomingEvents().get(position).getDateEvent());
        holder.textViewHomeTeam.setText(upcomingResults.getUpcomingEvents().get(position).getStrHomeTeam());
        holder.textViewAwayTeam.setText(upcomingResults.getUpcomingEvents().get(position).getStrAwayTeam());
    }

    @Override
    public int getItemCount() {
        if(upcomingResults != null && upcomingResults.getUpcomingEvents() != null) {
            return upcomingResults.getUpcomingEvents().size();
        }
        return 0;
    }

    class UpcomingMatchViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewEventDate, textViewHomeTeam, textViewAwayTeam;
        UpcomingMatchViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewEventDate = itemView.findViewById(R.id.textViewUpcomingEventDate);
            textViewHomeTeam = itemView.findViewById(R.id.textViewUpcomingHomeTeam);
            textViewAwayTeam = itemView.findViewById(R.id.textViewUpcomingAwayTeam);
        }
    }
}
