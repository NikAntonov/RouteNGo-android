package hu.pe.routengo.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import hu.pe.routengo.R;
import hu.pe.routengo.entity.Place;
import hu.pe.routengo.presenter.PlaceInfoActivity;

/**
 * Created by anton on 18.02.2017.
 */

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.MyViewHolder> {

    private List<Place> placeList;
    public static String username;
    private TextView name;
    private TextView shortDescription;

    public PlaceListAdapter(List<Place> places) {
        placeList = places;
    }


    @Override
    public PlaceListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_places_main, parent, false);
        return new PlaceListAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PlaceListAdapter.MyViewHolder holder, int position) {
        Place place = placeList.get(position);
        Glide.with(holder.view.getContext())
                .load(place.getImageUrl())
                .centerCrop()
                .into(holder.imageView);
        holder.view.setOnClickListener(v -> {
            Intent intent = new Intent(holder.view.getContext(), PlaceInfoActivity.class);
            holder.view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView name;
        public TextView shortDescription;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            name = (TextView) itemView.findViewById(R.id.name_card_main);
            shortDescription = (TextView) itemView.findViewById(R.id.shortdescription_card_main);
            imageView = (ImageView) itemView.findViewById(R.id.img_card_main);
        }
    }
}
