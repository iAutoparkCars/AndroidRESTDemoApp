package com.mobile.buttonusertransfer.data.remote;
import com.mobile.buttonusertransfer.data.model.User;

/**
 * Created by Steven on 3/13/2018.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*
    interface contains methods to execute HTTP requests such as POST, PUT, and DELETE.
*/

public interface APIService {

    /*
        execute a POST request when this method postCreateUser(...) is called

        @POST("/someEntity")
        The argument value for the @POST annotation is the endpoint—which is /someEntity.
        So the full URL will be http://baseUrl.com/someEntity
        In this case, it will just be http://fake-button.herokuapp.com/user
    */
    @POST("/user")
    @FormUrlEncoded
    Call<User> postCreateUser(@Field("name") String name,
                              @Field("email") String email,
                              @Field("candidate") String candidate);

    @POST("/user")
    Call<User> postCreateUser(@Body User body);


    /*
        http://fake-button.herokuapp.com/user?candidate=stevesCandidateKey

        The first @Query param will add the '?', resulting in above.
        2nd, 3rd, ...@Query params will be added with a '&' such as:
        /user?candidate=candidateKeyValue&param2=param2Value
     */
    @GET("/user")
    Call<List<User>> getAllUsers(@Query("candidate") String candidateKey);


}
