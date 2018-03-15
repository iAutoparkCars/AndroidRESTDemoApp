package com.mobile.buttonusertransfer.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mobile.buttonusertransfer.CreateUserActivity;
import com.mobile.buttonusertransfer.data.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Steven on 3/15/2018.
 */

public class CreateUserViewModel {

    final String TAG = getClass().getSimpleName();

    public void onCreateUser(View view, String name, String email){
        CreateUserActivity activity = (CreateUserActivity) getActivity(view);


        activity.createUser(new User(name, email, activity.getCandidateKey()));
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

    public void createUser(final CreateUserActivity activity, User model){
        activity.mAPIService.postCreateUser(model).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()){
                    Toast.makeText(activity, "Success. Response: " + response.body().toString(), Toast.LENGTH_LONG).show();
                    //Log.d(TAG, response.body().toString());
                } else{     // non-unique email, invalid ID, etc.
                    Log.d(TAG, "Response wasn't successful");
                    Log.d(TAG, response.code() + "");
                    Log.d(TAG, response.message().toString());
                    Log.d(TAG, call.request().url().toString());
                    Toast.makeText(activity, "Unsuccessful. Email may already exist.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "Unable to POST to API");
                Log.e(TAG, t.toString());
            }
        });
    }

}
