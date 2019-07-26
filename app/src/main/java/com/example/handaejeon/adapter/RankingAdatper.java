package com.example.handaejeon.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.handaejeon.R;
import com.example.handaejeon.model.RankingInfo;

import java.util.List;

public class RankingAdatper extends RecyclerView.Adapter<RankingAdatper.ViewHolder> {

    List<RankingInfo> itemlist;

    public RankingAdatper(List<RankingInfo> rankingInfos) {
        this.itemlist = rankingInfos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_basketball, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RankingInfo info = itemlist.get(i);
        viewHolder.tv_rank.setText(info.ranking);
        viewHolder.tv_point.setText(info.point);
        viewHolder.tv_name.setText(info.username);
    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_rank, tv_name,tv_point;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rank = itemView.findViewById(R.id.tv_rank);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_point = itemView.findViewById(R.id.tv_point);

        }
    }
}
