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

public class UserListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private String TAG = getClass().getName();
    private List<User> mDataset;
    private LayoutInflater inflater;
    public int lastPosition = -1;
    private Context context;
    public String name;

    public UserListAdapter(){
        mDataset = new LinkedList<User>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflate a new view for data binding
        context = parent.getContext();
        inflater = LayoutInflater.from(context);
        ViewUserListItemBinding viewBinding = DataBindingUtil.inflate(inflater, R.layout.view_user_list_item, parent, false);

        // pass viewBinding into each item of the list
        return new ViewHolder(viewBinding, parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // one-way binding from POJO -> layout
        User vidItem = mDataset.get(position);
        holder.bind(vidItem, this.context);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addItems(List<User> list){

        mDataset.clear();
        if (mDataset == null)
            mDataset = new LinkedList<>();

        for (User item : list){
            mDataset.add(item);
        }
    }
}
