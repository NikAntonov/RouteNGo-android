package hu.pe.routengo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import hu.pe.routengo.R;
import hu.pe.routengo.entity.Route;
import hu.pe.routengo.presenter.MapsActivity;

/**
 * Created by anton on 18.02.2017.
 */
public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.MyViewHolder> {

    private List<Route> mData;
    public static String username;
    private TextView time;
    private TextView distance;

    public RouteAdapter(List<Route> routes) {
        mData = routes;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_routes_main, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Route route = mData.get(position);

        Context context = holder.view.getContext();
        Log.i("tag", route.getType());
        if (route.getType().equals("bar")) {
            Glide.with(context)
                    .load(R.drawable.bar_black)
                    .centerCrop()
                    .into(holder.type);
        } else {
            Glide.with(context)
                    .load(R.drawable.history_black)
                    .centerCrop()
                    .into(holder.type);
        }
        holder.time.setText("12 min");

        holder.view.setOnClickListener(v -> new AlertDialog.Builder(context)
                .setTitle("Start this route?")
                .setMessage("You will visit historical places in range 7 km")
                .setPositiveButton("Yes", (dialog, arg1) -> {
                    Intent intent = new Intent(context, MapsActivity.class);
                    Gson gson = new GsonBuilder().create();
                    String string = gson.toJson(route);
                    intent.putExtra("route", string);
                    context.startActivity(intent);
                }).setNegativeButton("Cancel", (dialog, arg1) -> {
                    dialog.dismiss();
                }).setCancelable(true).create().show());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView time;
        public TextView distance;
        public TextView places;
        public ImageView type;

        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            time = (TextView) itemView.findViewById(R.id.time_card_main);
            distance = (TextView) itemView.findViewById(R.id.distance_card_main);
            type = (ImageView) itemView.findViewById(R.id.type_card_main);
            //places =(TextView) itemView.findViewById(R.id.places_card_main);
        }
    }

}
