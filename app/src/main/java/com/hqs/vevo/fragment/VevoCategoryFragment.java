package com.hqs.vevo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hqs.vevo.R;

/**
 * Created by Hqs on 2017/11/13
 */
public class VevoCategoryFragment extends Fragment {

    public static VevoCategoryFragment newInstance(String tag) {
        Bundle args = new Bundle();
        args.putString("tag",tag);
        VevoCategoryFragment fragment = new VevoCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vevo_category, null);
        TextView tvTag = (TextView) view.findViewById(R.id.tv_tag);
        String tag =getArguments().getString("tag");
        Log.e("tag",tag);
        tvTag.setText(tag);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
