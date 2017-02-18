package hu.pe.routengo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hu.pe.routengo.R;
import hu.pe.routengo.entity.Place;
import hu.pe.routengo.entity.Route;

/**
 * Created by anton on 18.02.2017.
 */

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.MyViewHolder>{

    private ArrayList<Place> mData;
    public static String username;
    private TextView name;
    private TextView shortdescription;

    public PlaceListAdapter(ArrayList<Place> places) {
        mData = places;
    }


    @Override
    public PlaceListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_places_main, parent, false);
        return new PlaceListAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PlaceListAdapter.MyViewHolder holder, int position) {
        holder.position = position;
        holder.view.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView name;
        public TextView shortdescription;
        public ImageView img;
        public int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            name = (TextView) itemView.findViewById(R.id.name_card_main);
            shortdescription = (TextView) itemView.findViewById(R.id.shortdescription_card_main);
            img = (ImageView) itemView.findViewById(R.id.img_card_main);
        }
    }

}
