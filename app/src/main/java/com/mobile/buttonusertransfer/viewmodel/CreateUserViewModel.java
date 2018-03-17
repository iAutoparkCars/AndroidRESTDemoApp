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


/**
 *  Class ViewModel -- where all the UI logic occurs, to ensure separation between and the view (Activity)
 */

public class CreateUserViewModel {

    // constants
    final String TAG = getClass().getSimpleName();
    private final String candidateKey = "stevesCandidateKey";

    /**
     When the user clicks the 'create user' button (the plus), a POST request is made,
     response is displayed as a Toast to the user
     @param view is the root view of what was clicked
     @param name is the name the user entered in the EditText
     @param email is the email the user entered in the EditText
     */
    public void onCreateUser(View view, String name, String email){
        CreateUserActivity activity = (CreateUserActivity) getActivity(view);
        createUser(activity, new User(name, email, candidateKey));
        Log.i("createviewModel", "clicked name: " + name + " email: " + email);
    }

    /**
     When the user clicks the 'view users' button, a GET request is made to view users;
     the JSON response is parsed and displayed as a RecyclerView list in a fragment
     @param view is the root view of what was clicked
     */
    public void onViewUsers(View view){
        CreateUserActivity activity = (CreateUserActivity) getActivity(view);
        getAllUsers(activity);
    }

    /**
     A POST request is made to create the User
     @param activity the activity where the Toast/JSON response is displayed
     @param model contains the data that the user entered (name, email,...)
     */
    public void createUser(final CreateUserActivity activity, User model){

        if (!model.hasValidEmail() || !model.hasValidName()){
            Toast.makeText(activity, activity.getString(R.string.invalidCreds), Toast.LENGTH_SHORT).show();
            return;
        }

        activity.mAPIService.postCreateUser(model).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()){
                    Toast.makeText(activity, activity.getString(R.string.responseSuccess) + response.body().toString(), Toast.LENGTH_LONG).show();
                    //Log.d(TAG, response.body().toString());
                } else{     // non-unique email, invalid ID, etc.
                    Log.d(TAG, "Response wasn't successful");
                    Log.d(TAG, response.code() + "");
                    Log.d(TAG, response.message().toString());
                    Log.d(TAG, call.request().url().toString());
                    Toast.makeText(activity, activity.getString(R.string.nonUniqueEmail), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, activity.getString(R.string.networkingError));
                Log.e(TAG, t.toString());
            }
        });
    }

    /**
     Starts the fragment containing a List to view the users
     @param activity is where the JSON response is displayed as a fragment
     */
    public void getAllUsers(final CreateUserActivity activity){
        activity.mAPIService.getAllUsers(candidateKey).enqueue(new Callback<List<User>>() {
            List<User> users = null;
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    List<User> users = response.body();

                    // add Users to the list
                    activity.getUserlistFragment().addItems(users);

                    // start fragment to view the list of users
                    FragmentManager manager = activity.getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.constraint_root, activity.getUserlistFragment());
                        transaction.addToBackStack(null);
                        transaction.commit();

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
    }

    /**
     Given a view, return the base activity
     @param view is the given view
     @returns the base activity
     */
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
