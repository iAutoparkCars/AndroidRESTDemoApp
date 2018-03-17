package com.mobile.buttonusertransfer.view;

/**
 * Created by Steven on 11/12/2017.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mobile.buttonusertransfer.R;
import com.mobile.buttonusertransfer.data.model.User;
import com.mobile.buttonusertransfer.databinding.ViewUserListItemBinding;

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

    ViewUserListItemBinding cardBinding;

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // inflate a new view
        /*if (inflater == null) {
            context = parent.getContext();
            inflater = LayoutInflater.from(context);
        }*/

        context = parent.getContext();
        inflater = LayoutInflater.from(context);

        ViewUserListItemBinding viewBinding = DataBindingUtil.inflate(inflater, R.layout.view_user_list_item, parent, false);
        //ViewUserListItemBinding viewBinding = DataBindingUtil.inflate(inflater, R.layout.view_video_card, parent,false);

        // pass viewBinding into
        return new ViewHolder(viewBinding, parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ViewUserListItemBinding binding = holder.cardBinding;

        User vidItem = mDataset.get(position);
        holder.bind(vidItem, this.context);
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
