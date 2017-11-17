package com.hqs.vevo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hqs on 2017/11/17
 * 作家的信息
 */
public class LifeExpert implements Parcelable{

    private String iconUrl ;                                                           // 照片
    private String expertTitle ;                                                    // 昵称
    private String expertDescription ;                                        // 描述、介绍
    private int articleNum ;                                                          // 文章数量
    private int followerNum ;                                                       // 粉丝数量

    protected LifeExpert(Parcel in) {
        iconUrl = in.readString();
        expertTitle = in.readString();
        expertDescription = in.readString();
        articleNum = in.readInt();
        followerNum = in.readInt();
    }

    public static final Creator<LifeExpert> CREATOR = new Creator<LifeExpert>() {
        @Override
        public LifeExpert createFromParcel(Parcel in) {
            return new LifeExpert(in);
        }

        @Override
        public LifeExpert[] newArray(int size) {
            return new LifeExpert[size];
        }
    };

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getExpertTitle() {
        return expertTitle;
    }

    public void setExpertTitle(String expertTitle) {
        this.expertTitle = expertTitle;
    }

    public String getExpertDescription() {
        return expertDescription;
    }

    public void setExpertDescription(String expertDescription) {
        this.expertDescription = expertDescription;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public int getFollowerNum() {
        return followerNum;
    }

    public void setFollowerNum(int followerNum) {
        this.followerNum = followerNum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iconUrl);
        dest.writeString(expertTitle);
        dest.writeString(expertDescription);
        dest.writeInt(articleNum);
        dest.writeInt(followerNum);
    }
}
