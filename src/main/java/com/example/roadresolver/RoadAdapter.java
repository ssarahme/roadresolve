package com.example.roadresolver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoadAdapter extends RecyclerView.Adapter<RoadAdapter.RoadViewHolder> {

    private Context mCtx;
    private List<Road> roadList;

    public RoadAdapter(Context mCtx, List<Road> roadList) {
        this.mCtx = mCtx;
        this.roadList = roadList;
    }

    @Override
    public RoadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.road_list, null);

        return new RoadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoadViewHolder holder, int position) {
        Road road = roadList.get(position);

        holder.textViewTitle.setText(String.valueOf(road.getTitle()));
        holder.textViewDesc.setText(String.valueOf(road.getDesc()));
    }

    @Override
    public int getItemCount() {
        return roadList.size();
    }

    public static class RoadViewHolder extends RecyclerView.ViewHolder {
        TextView  textViewTitle, textViewDesc;

        public RoadViewHolder(View itemView) {
            super(itemView);


            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
        }
    }
}
