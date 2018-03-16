package com.mobile.buttonusertransfer.viewmodel;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mobile.buttonusertransfer.CreateUserActivity;
import com.mobile.buttonusertransfer.R;
import com.mobile.buttonusertransfer.data.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Steven on 3/15/2018.
 */

public class CreateUserViewModel {

    final String TAG = getClass().getSimpleName();
    private final String candidateKey = "stevesCandidateKey";

    public void onCreateUser(View view, String name, String email){
        CreateUserActivity activity = (CreateUserActivity) getActivity(view);
        createUser(activity, new User(name, email, candidateKey));
        //activity.createUser(new User(name, email, activity.getCandidateKey()));
        Log.i("createviewModel", "clicked name: " + name + " email: " + email);
    }

    public void onViewUsers(View view){
        CreateUserActivity activity = (CreateUserActivity) getActivity(view);
        getAllUsers(activity);
    }

    public void createUser(final CreateUserActivity activity, User model){

        if (model.getName() == null || model.getEmail() == null ||
                model.getName().length() <= 1 || model.getEmail().length() <= 1){
            Toast.makeText(activity, "Name or email is empty", Toast.LENGTH_SHORT).show();
            return;
        }


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

    List<User> users;
    public List<User> getAllUsers(final CreateUserActivity activity){
        activity.mAPIService.getAllUsers(candidateKey).enqueue(new Callback<List<User>>() {
            List<User> users = null;
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    List<User> users = response.body();
                    //Toast.makeText(CreateUserActivity.this, "Success. Response: " + response.body().toString(), Toast.LENGTH_LONG).show();

                    // starting the fragment here...unless i want to use an interface
                    // for "callback", eventbus, or observable pattern with rxjava

                    //
                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.constraint_root, activity.getUserlistFragment());
                    Log.d(TAG, users + "");

                } else{     // non-unique email, invalid ID, etc.
                    Log.d(TAG, "Response wasn't successful");
                    Log.d(TAG, response.code() + "");
                    Log.d(TAG, response.message().toString());
                    Log.d(TAG, call.request().url().toString());
                    Toast.makeText(activity, "Unsuccessful. Email may already exist.", Toast.LENGTH_SHORT).show();
                    users = new ArrayList<User>();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, "Unable to GET users");
                Log.e(TAG, t.toString());
                users = new ArrayList<User>();
            }
        });
        return users;
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
