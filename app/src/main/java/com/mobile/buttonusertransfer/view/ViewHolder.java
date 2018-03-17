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

    public ViewHolder(ViewUserListItemBinding dataBinding, View v) {
        super(dataBinding.getRoot());
        this.cardBinding = dataBinding;
    }

    public void ViewHolder() {}

    // bind the POJO User to the data in the UI
    public void bind (User model, Context context) { this.cardBinding.setUser(model); }

    public ViewUserListItemBinding getBinding() { return this.cardBinding; }
}
