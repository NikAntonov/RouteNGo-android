package hu.pe.routengo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

import hu.pe.routengo.R;
import hu.pe.routengo.entity.Objective;

/**
 * Created by Galya Sheremetova on 19.02.2017.
 */

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.MyViewHolder> {
    private List<Objective> objectives;

    public GoalsAdapter(List<Objective> objectives) {
        this.objectives = objectives;
    }


    @Override
    public GoalsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_task_main, parent, false);
        return new GoalsAdapter.MyViewHolder(v);
    }

    public void onBindViewHolder(final GoalsAdapter.MyViewHolder holder, int position) {
        Objective objective = objectives.get(position);
        Glide.with(holder.view.getContext())
                .load(objective.getImageId())
                .centerCrop()
                .into(holder.imageView);
        holder.button.setOnClickListener(v -> {
            objective.setMarcked(1);
            Collections.sort(objectives, (o1, o2) -> o1.getMarcked() - o2.getMarcked());
        });
    }

    @Override
    public int getItemCount() {
        return objectives.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageView;
        public ToggleButton button;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            button = (ToggleButton) itemView.findViewById(R.id.toggleButton);
            imageView = (ImageView) itemView.findViewById(R.id.img_card_task);
        }
    }
}
