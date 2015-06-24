package com.nokee.recyclerview;

/**
 * Created by feng on 15-6-23.
 */

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StaggeredAdapter extends MySimpleAdapter {

    private List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String> datas) {
        super(context, datas);

        mHeights = new ArrayList<Integer>();
        for(int i=0; i < mDatas.size(); i++) {
            mHeights.add((int)(100+Math.random()*300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) myViewHolder.itemView.getLayoutParams();
        lp.height = mHeights.get(i);
        myViewHolder.itemView.setLayoutParams(lp);
        myViewHolder.tv.setText(mDatas.get(i));

        setUpItemEvent(myViewHolder);
    }

}


