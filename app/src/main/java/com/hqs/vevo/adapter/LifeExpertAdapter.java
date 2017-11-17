package com.hqs.vevo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hqs.vevo.R;
import com.hqs.vevo.bean.LifeExpert;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Hqs on 2017/11/16
 */
public class LifeExpertAdapter extends RecyclerView.Adapter<LifeExpertAdapter.LifeExpertViewHolder> {

    private List<LifeExpert> mLifeExperts ;
    private Context mContext ;

    public LifeExpertAdapter(List<LifeExpert> lifeExperts , Context context){
        this.mLifeExperts = lifeExperts ;
        this.mContext = context ;
    }

    @Override
    public LifeExpertViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_life_expert, null, false);
        LifeExpertViewHolder viewHolder = new LifeExpertViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LifeExpertViewHolder holder, int position) {
        LifeExpert lifeExpert = mLifeExperts.get(position);
        holder.tvWriter.setText(lifeExpert.getExpertTitle());
        holder.tvWriterDescription.setText(lifeExpert.getExpertDescription());
        holder.tvFollowerNum.setText(lifeExpert.getFollowerNum()+"");
        holder.tvArticleNum.setText(lifeExpert.getArticleNum()+"");
        Picasso.with(mContext).load(lifeExpert.getIconUrl()).into(holder.ivIconLifeExpert);
    }

    @Override
    public int getItemCount() {
        return mLifeExperts.size();
    }

    public class LifeExpertViewHolder extends RecyclerView.ViewHolder{

        CircleImageView ivIconLifeExpert ;                          // artist的头像
        TextView tvWriter ;                                                        // artist的昵称
        TextView tvWriterDescription ;                                   // artist的描述、介绍
        TextView tvArticleNum ;                                              // artist的文章数量
        TextView tvFollowerNum ;                                           // artist的粉丝的数量

        public LifeExpertViewHolder(View itemView) {
            super(itemView);
            ivIconLifeExpert = (CircleImageView) itemView.findViewById(R.id.iv_icon_life_expert);
            tvWriter = (TextView) itemView.findViewById(R.id.tv_writer);
            tvWriterDescription = (TextView) itemView.findViewById(R.id.tv_writer_description);
            tvArticleNum = (TextView) itemView.findViewById(R.id.tv_article_num);
            tvFollowerNum = (TextView) itemView.findViewById(R.id.tv_follower_num);
        }
    }
}
