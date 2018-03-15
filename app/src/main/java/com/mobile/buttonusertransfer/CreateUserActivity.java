package com.mobile.buttonusertransfer;

import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mobile.buttonusertransfer.data.model.Post;
import com.mobile.buttonusertransfer.data.remote.APIService;
import com.mobile.buttonusertransfer.data.remote.ApiUtils;
import com.mobile.buttonusertransfer.databinding.ActivityCreateUserBinding;
import com.mobile.buttonusertransfer.viewmodels.CreateUserViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity {

    private final String TAG = CreateUserActivity.class.getName();
    public final String candidateKey = "stevesCandidateKey";

    public APIService mAPIService;

    public ActivityCreateUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // create binding for this layout and set for User
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_user);
        Post user = new Post();
        binding.setUser(user);
        binding.setCreateUserViewModel(new CreateUserViewModel());

        mAPIService = ApiUtils.getAPIService();

        String name = "name1";
        String email = "friend1234@gmail.com";
        //createUser(name, email, "stevesCandidateKey");

        // create request body
        Post postTest = new Post();
        postTest.setName("name2");
        postTest.setEmail("chris7@usebutton.com");
        postTest.setCandidate("stevesCandidateKey");
        //createUser(postTest);
    }

    public void createUser(String name, String email, String candidate){
        mAPIService.postCreateUser(name, email, candidate).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()){
                    Log.d(TAG, response.body().toString());
                } else{     // non-unique email, invalid ID, etc.
                    Log.d(TAG, "Response wasn't successful");
                    Log.d(TAG, response.code() + "");
                    Log.d(TAG, response.message().toString());
                    Log.d(TAG, call.request().url().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG, "Unable to POST to API");
                Log.e(TAG, t.toString());
            }
        });
    }

    public void createUser(Post model){
        mAPIService.postCreateUser(model).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()){
                    Toast.makeText(CreateUserActivity.this, "Success. Response: " + response.body().toString(), Toast.LENGTH_LONG).show();
                    //Log.d(TAG, response.body().toString());
                } else{     // non-unique email, invalid ID, etc.
                    Log.d(TAG, "Response wasn't successful");
                    Log.d(TAG, response.code() + "");
                    Log.d(TAG, response.message().toString());
                    Log.d(TAG, call.request().url().toString());
                    Toast.makeText(CreateUserActivity.this, "Unsuccessful. Email may already exist.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG, "Unable to POST to API");
                Log.e(TAG, t.toString());
            }
        });
    }
}
