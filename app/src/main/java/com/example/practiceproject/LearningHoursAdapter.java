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

public class LearningHoursAdapter extends RecyclerView.Adapter<LearningHourViewHolder> {

    private List<LearningHours> learningHoursList = new ArrayList<>();
    private Context context;

    public LearningHoursAdapter(Context context) {
        this.context = context;
    }


    void addLearningHour(List<LearningHours> learningHoursList){
        this.learningHoursList = learningHoursList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LearningHourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_learning_leader,parent,false);
        return new LearningHourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningHourViewHolder holder, int position) {

        LearningHours learningHours = learningHoursList.get(position);
        holder.binding(learningHours);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(learningHoursList.get(position).getLearningBadge())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.badgeImage);

    }

    @Override
    public int getItemCount() {
        return learningHoursList.size();
    }
}

class LearningHourViewHolder extends RecyclerView.ViewHolder{
    ImageView badgeImage;
    TextView  tvName;
    TextView tvHour;
    TextView tvCountry;

    public LearningHourViewHolder(@NonNull View itemView) {
        super(itemView);
        badgeImage = itemView.findViewById(R.id.img_icon_learning_leader);
        tvName = itemView.findViewById(R.id.learning_name);
        tvHour = itemView.findViewById(R.id.learning_duration);
        tvCountry = itemView.findViewById(R.id.learning_location);
    }

    public void binding(LearningHours learningHours){

        tvName.setText(learningHours.getName());
        tvCountry.setText(learningHours.getCountry());
        tvHour.setText(Integer.toString(learningHours.getHours()));

    }
}
