package com.example.pickachew.Matches;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pickachew.R;

import org.w3c.dom.Text;

public class MatchesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView mMatchId, mMatchName;

    public MatchesViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        mMatchId = (TextView) itemView.findViewById(R.id.MatchId);

    }

    @Override
    public void onClick(View v) {

    }
}
