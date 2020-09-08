package com.example.practiceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SkillScoresAdapter extends RecyclerView.Adapter<SkillScoresAdapter.SkillScoresViewHolder>  {
    List<SkillScores> skillScoresList = new ArrayList<>();
    Context context;

    public SkillScoresAdapter(Context context) {
        this.context = context;
    }


    public void SkillScoresAdapter(List<SkillScores> skillScoresList) {
        this.skillScoresList = skillScoresList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SkillScoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_skill_leader, parent, false);
        return new SkillScoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillScoresViewHolder holder, int position) {
        SkillScores skillScores = skillScoresList.get(position);
        holder.bindResources(skillScores);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(skillScoresList.get(position).getBadgeUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.badgeImage);

    }

    @Override
    public int getItemCount() {
        return skillScoresList.size();
    }

    public class SkillScoresViewHolder extends RecyclerView.ViewHolder{
        ImageView badgeImage;
        TextView tvSkillScore;
        TextView tvCountry;
        TextView tvName;

        public SkillScoresViewHolder(@NonNull View itemView) {
            super(itemView);

            badgeImage = itemView.findViewById(R.id.img_icon_skill_leader);
            tvSkillScore = itemView.findViewById(R.id.skill_score);
            tvCountry = itemView.findViewById(R.id.skill_location);
            tvName = itemView.findViewById(R.id.skill_name);
        }

        public void bindResources(SkillScores skillScores){

            tvName.setText(skillScores.getName());
            tvCountry.setText(skillScores.getCountry());
            tvSkillScore.setText(Integer.toString(skillScores.getScore()));
        }
    }


}
