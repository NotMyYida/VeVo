package com.hqs.vevo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hqs on 2017/11/16
 */
public class LifeExpertAdapter extends RecyclerView.Adapter<LifeExpertAdapter.LifeExpertViewHolder> {

    public LifeExpertAdapter(){

    }

    @Override
    public LifeExpertViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LifeExpertViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LifeExpertViewHolder extends RecyclerView.ViewHolder{

        public LifeExpertViewHolder(View itemView) {
            super(itemView);
        }
    }
}
