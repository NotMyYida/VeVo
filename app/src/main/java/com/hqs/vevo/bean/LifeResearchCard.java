package com.hqs.vevo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hqs on 2017/11/17
 * 生活研究卡片 的 POJO
 */
public class LifeResearchCard implements Parcelable{

    private String coverUrl ;                           // 背景封面
    private String volNum ;                            // vol 编号
    private String lifeResearchTitle ;            // 卡片的标题
    private int collectNum ;                             // 收藏的个数
    private int readNum ;                                // 阅读量

    protected LifeResearchCard(Parcel in) {
        coverUrl = in.readString();
        volNum = in.readString();
        lifeResearchTitle = in.readString();
        collectNum = in.readInt();
        readNum = in.readInt();
    }

    public static final Creator<LifeResearchCard> CREATOR = new Creator<LifeResearchCard>() {
        @Override
        public LifeResearchCard createFromParcel(Parcel in) {
            return new LifeResearchCard(in);
        }

        @Override
        public LifeResearchCard[] newArray(int size) {
            return new LifeResearchCard[size];
        }
    };

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getVolNum() {
        return volNum;
    }

    public void setVolNum(String volNum) {
        this.volNum = volNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public String getLifeResearchTitle() {
        return lifeResearchTitle;
    }

    public void setLifeResearchTitle(String lifeResearchTitle) {
        this.lifeResearchTitle = lifeResearchTitle;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(coverUrl);
        dest.writeString(volNum);
        dest.writeString(lifeResearchTitle);
        dest.writeInt(collectNum);
        dest.writeInt(readNum);
    }
}
