package com.hqs.vevo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.hqs.vevo.R;

/**
 * Created by Hqs on 2017/11/15
 */
public class VevoExploreFragment extends Fragment {

    public static VevoExploreFragment newInstance() {
        Bundle args = new Bundle();

        VevoExploreFragment fragment = new VevoExploreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vevo_explore, container,false);
        RecyclerView lifeExpertRecycler = (RecyclerView) view.findViewById(R.id.life_expert_list);

//
        return view;
    }
}
