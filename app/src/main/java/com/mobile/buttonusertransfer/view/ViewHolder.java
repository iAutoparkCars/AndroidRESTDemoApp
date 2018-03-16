package com.mobile.buttonusertransfer.view;

import android.content.Context;
//import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;


public class ViewHolder extends RecyclerView.ViewHolder {

    private String TAG = getClass().getName();
    //public ViewVideoCardBinding cardBinding;
    public int containerId = 0;
    //public CardView cardView;
    private Animation animation = null;

    public ViewHolder(View itemView) {
        super(itemView);
    }

    /*public ViewHolder(ViewVideoCardBinding dataBinding, View v) {
        super(dataBinding.getRoot());
        this.cardBinding = dataBinding;
    }*/

    public void ViewHolder() {
    }

    public void setAnimation(Animation animation){
        this.animation = animation;
    }

    public void bind (Object model, Context context)
    {

  /*      if (animation != null){
            getBinding().cardView.startAnimation(animation);
        }

        this.cardBinding.setVideoItem(model);

        // call this to bind the ViewModel to this item in RecView (the ViewHolder)
        this.cardBinding.setItemViewModel(new ListItemViewModel(model, context));*/
    }

    //public ViewVideoCardBinding getBinding() { return this.cardBinding; }

}
