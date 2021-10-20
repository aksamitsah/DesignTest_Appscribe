package me.aksamitsah.trivia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.aksamitsah.trivia.R;
import me.aksamitsah.trivia.model.Score;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {

    private final ArrayList<Score> data;
    private final Context context;

    public ScoreAdapter(ArrayList<Score> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_score_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Score modal = data.get(position);
        holder.txt_gameID.setText(modal.getGame());
        holder.txt_name.setText(modal.getPlayerName());
        holder.txt_bestCricketer.setText(modal.getAnsOne());
        holder.txt_indianColor.setText(modal.getAnsTwo());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView txt_gameID;
        private final TextView txt_name;
        private final TextView txt_bestCricketer;
        private final TextView txt_indianColor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_gameID = itemView.findViewById(R.id.txt_gameID);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_bestCricketer = itemView.findViewById(R.id.txt_bestCricketer);
            txt_indianColor = itemView.findViewById(R.id.txt_indianColor);

        }
    }
}

