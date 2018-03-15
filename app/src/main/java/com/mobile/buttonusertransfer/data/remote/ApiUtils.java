package com.mobile.buttonusertransfer.data.remote;

/**
 * Created by Steven on 3/13/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://fake-button.herokuapp.com";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}
