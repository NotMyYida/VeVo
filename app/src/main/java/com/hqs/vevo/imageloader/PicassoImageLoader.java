package com.hqs.vevo.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.hqs.vevo.R;
import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Hqs on 2017/11/10
 * Banner 的 ImageLoader，详情见 https://github.com/youth5201314/banner
 */
public class PicassoImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        // 高质量图片，使用 Picasso 来加载
        Picasso.with(context).load((String)path).placeholder(R.mipmap.gallery_colored).into(imageView);

    }

}
