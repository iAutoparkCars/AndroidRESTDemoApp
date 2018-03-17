package com.mobile.buttonusertransfer.view;

import android.content.Context;
//import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;

import com.mobile.buttonusertransfer.data.model.User;
import com.mobile.buttonusertransfer.databinding.ViewUserListItemBinding;


public class ViewHolder extends RecyclerView.ViewHolder {

    private String TAG = getClass().getSimpleName();
    public ViewUserListItemBinding cardBinding;
    public int containerId = 0;
    //public CardView cardView;

    public ViewHolder(ViewUserListItemBinding dataBinding, View v) {
        super(dataBinding.getRoot());
        this.cardBinding = dataBinding;
    }

    public void ViewHolder() {}

    public void bind (User model, Context context)
    {
        this.cardBinding.setUser(model);
        //this.cardBinding.setVideoItem(model);

        // call this to bind the ViewModel to this item in RecView (the ViewHolder)
        //this.cardBinding.setItemViewModel(new ListItemViewModel(model, context));
    }

    public ViewUserListItemBinding getBinding() { return this.cardBinding; }

}
