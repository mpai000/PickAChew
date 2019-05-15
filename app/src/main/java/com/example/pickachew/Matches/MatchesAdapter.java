package com.example.pickachew.Matches;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.pickachew.R;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesViewHolder>{

    private List<MatchesObject> matchesList;
    private Context context;

    public MatchesAdapter(List<MatchesObject> matchesList, Context context){
        this.matchesList = matchesList;
        this.context = context;
    }



    @Override
    public MatchesViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matches, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        MatchesViewHolder rcv = new MatchesViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(MatchesViewHolder holder, int position) {
        holder.mMatchId.setText(matchesList.get(position).getUserID());
//        holder.mMatchName.setText(matchesList.get(position).getName());
//        try {
//            holder.mCuisine.setText(matchesList.get(position).getCuisine());
//        }
//        catch (java.lang.NullPointerException e){
//            e.printStackTrace();
//        }
//        if(!matchesList.get(position).getProfileImageUrl().equals("default")){
//            Glide.with(context).load(matchesList.get(position).getProfileImageUrl()).into(holder.mMatchImage);
        }


    @Override
    public int getItemCount() {
        return this.matchesList.size();
    }
}
