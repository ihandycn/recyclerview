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

/**
 * Created by feng on 15-6-23.
 */
public class StaggeredAdapter extends RecyclerView.Adapter<MyViewHolder2> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    private List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);

        mHeights = new ArrayList<Integer>();
        for(int i=0; i < mDatas.size(); i++) {
            mHeights.add((int)(100+Math.random()*300));
        }
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_single_textview, viewGroup, false);
        MyViewHolder2 viewHolder = new MyViewHolder2(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder2 myViewHolder, int i) {
        StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) myViewHolder.itemView.getLayoutParams();
        lp.height = mHeights.get(i);
        myViewHolder.itemView.setLayoutParams(lp);
        myViewHolder.tv.setText(mDatas.get(i));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MyViewHolder2 extends RecyclerView.ViewHolder {

    TextView tv;

    public MyViewHolder2(View itemView) {
        super(itemView);
        tv = (TextView)itemView.findViewById(R.id.tv);
    }
}

