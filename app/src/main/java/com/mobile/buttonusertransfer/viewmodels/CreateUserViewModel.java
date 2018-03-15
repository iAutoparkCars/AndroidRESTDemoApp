package com.mobile.buttonusertransfer.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mobile.buttonusertransfer.CreateUserActivity;
import com.mobile.buttonusertransfer.data.model.Post;
import com.mobile.buttonusertransfer.databinding.ActivityCreateUserBinding;


/**
 * Created by Steven on 3/15/2018.
 */

public class CreateUserViewModel {

    public void onCreateUser(View view, String name, String email){
        CreateUserActivity activity = (CreateUserActivity) getActivity(view);
        activity.createUser(new Post(name, email, activity.candidateKey));
        Log.i("createviewModel", "clicked name: " + name + " email: " + email);
    }

    public Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }
}
