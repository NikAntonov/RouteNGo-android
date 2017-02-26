package hu.pe.routengo.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import hu.pe.routengo.R;
import hu.pe.routengo.entity.Objective;

/**
 * Created by Galya Sheremetova on 19.02.2017.
 */

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.MyViewHolder> {
    private List<Objective> objectives;
    private ArrayList<String> types = new ArrayList<>();

    public InterestAdapter(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    @Override
    public InterestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_task_main, parent, false);
        return new InterestAdapter.MyViewHolder(v);
    }

    public void onBindViewHolder(final InterestAdapter.MyViewHolder holder, int position) {
        Objective objective = objectives.get(position);
        Glide.with(holder.view.getContext())
                .load(objective.getImageId())
                .into(holder.imageView);
        holder.view.setOnClickListener(v -> {
            types.add(objective.getType());
            holder.view.setBackgroundColor(Color.CYAN);
        });
    }

    @Override
    public int getItemCount() {
        return objectives.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView imageView;
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = (TextView) itemView.findViewById(R.id.txt_card_task);
            imageView = (ImageView) itemView.findViewById(R.id.img_card_task);
        }
    }
}
