package com.mobile.buttonusertransfer;

import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobile.buttonusertransfer.data.model.User;
import com.mobile.buttonusertransfer.data.remote.APIService;
import com.mobile.buttonusertransfer.data.remote.ApiUtils;
import com.mobile.buttonusertransfer.databinding.ActivityCreateUserBinding;
import com.mobile.buttonusertransfer.view.ListFragment;
import com.mobile.buttonusertransfer.viewmodel.CreateUserViewModel;

public class CreateUserActivity extends AppCompatActivity {

    private final String TAG = CreateUserActivity.class.getName();

    public APIService mAPIService;
    public ActivityCreateUserBinding binding;

    // the fragment in which you can view the users
    private ListFragment userlistFragment;

    /**
        fetches the fragment for viewing users
        @return the user-list fragment
    */
    public ListFragment getUserlistFragment() {
        if (userlistFragment == null){
            userlistFragment = new ListFragment();
            return userlistFragment;
        }
        return userlistFragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // create binding for this layout and set for User
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_user);
        binding.setUser(new User());
        binding.setCreateUserViewModel(new CreateUserViewModel());

        // init the API to start calling
        mAPIService = ApiUtils.getAPIService();

        // init list fragment to view users
        userlistFragment = getUserlistFragment();
    }
}
