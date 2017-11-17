package com.hqs.vevo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hqs.vevo.R;
import com.hqs.vevo.bean.LifeResearchCard;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Hqs on 2017/11/17
 */
public class LifeResearchAdapter extends RecyclerView.Adapter<LifeResearchAdapter.LifeResearchViewHolder> {

    private List<LifeResearchCard> mLifeResearchCards ;
    private Context mContext ;

    public LifeResearchAdapter(List<LifeResearchCard> lifeResearchCards , Context context){
        this.mLifeResearchCards = lifeResearchCards ;
        this.mContext = context ;
    }

    @Override
    public LifeResearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_life_reserch, null, false);
        LifeResearchViewHolder viewHolder = new LifeResearchViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LifeResearchViewHolder holder, int position) {
        LifeResearchCard lifeResearchCard = mLifeResearchCards.get(position);
        holder.tvLifeResearchNo.setText(lifeResearchCard.getVolNum());
        holder.tvLifeResearchTitle.setText(lifeResearchCard.getLifeResearchTitle());
        holder.tvLifeResearchReadNum.setText(lifeResearchCard.getReadNum()+"");
        holder.tvLifeResearchCollectedNum.setText(lifeResearchCard.getCollectNum()+"");
        Picasso.with(mContext).load(lifeResearchCard.getCoverUrl()).into(holder.ivLifeResearchCover);
    }

    @Override
    public int getItemCount() {
        return mLifeResearchCards.size();
    }

    public class LifeResearchViewHolder extends RecyclerView.ViewHolder{

        ImageView ivLifeResearchCover ;             // 背景的图片
        TextView tvLifeResearchNo ;                      //  Vol 编号
        TextView tvLifeResearchTitle ;                  //  标题
        TextView tvLifeResearchReadNum ;        //  阅读数量
        TextView tvLifeResearchCollectedNum ; // 收藏数量

        public LifeResearchViewHolder(View itemView) {
            super(itemView);
            ivLifeResearchCover = (ImageView) itemView.findViewById(R.id.iv_life_research_cover);
            tvLifeResearchNo = (TextView) itemView.findViewById(R.id.tv_life_research_no);
            tvLifeResearchTitle = (TextView) itemView.findViewById(R.id.tv_life_research_title);
            tvLifeResearchReadNum = (TextView) itemView.findViewById(R.id.tv_life_research_read_num);
            tvLifeResearchCollectedNum = (TextView) itemView.findViewById(R.id.tv_life_research_collected_num);
        }
    }
}
