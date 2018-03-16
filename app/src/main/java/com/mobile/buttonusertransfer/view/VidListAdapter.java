package com.mobile.buttonusertransfer.view;

/**
 * Created by Steven on 11/12/2017.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.mobile.buttonusertransfer.data.model.User;

import java.util.LinkedList;
import java.util.List;

public class VidListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private String TAG = getClass().getName();
    private List<User> mDataset;
    private LayoutInflater inflater;
    public int lastPosition = -1;
    private Context context;
    public String name;
    public VidListAdapter(List<User> myDataset) {}

    public VidListAdapter(){
        mDataset = new LinkedList<User>();
    }

    //ViewVideoCardBinding cardBinding;

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       /*     // inflate a new view
        if (inflater == null) {
            context = parent.getContext();
            inflater = LayoutInflater.from(context);
        }

        ViewVideoCardBinding viewBinding = DataBindingUtil.inflate(inflater, R.layout.view_video_card, parent,false);

        // pass viewBinding into
        return new ViewHolder(viewBinding, parent);*/
       return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
      /*  ViewVideoCardBinding binding = holder.cardBinding;

        VideoItem vidItem = mDataset.get(position);

        if (lastPosition != -5) {
            Animation animation;
            animation = AnimationUtils.loadAnimation(context,
                    (position < lastPosition) ? R.anim.slide_down : R.anim.slide_up);
            holder.setAnimation(animation);
        }
        lastPosition = position;
        holder.bind(vidItem, this.context);*/
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // -- Override getItemId, getItemViewType to prevent repeated cards on scroll --
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void addItems(List<User> list){

        if (mDataset == null)
            mDataset = new LinkedList<>();

        for (User item : list){
            mDataset.add(item);
        }
    }

    public void addItem(User vid){

        mDataset.add(vid);
        //this.notifyDataSetChanged();

        //Log.d(TAG, "MainActivity tried to add item to list");

    }

}
