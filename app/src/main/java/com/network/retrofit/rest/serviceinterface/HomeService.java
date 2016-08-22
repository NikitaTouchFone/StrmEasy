package com.network.retrofit.rest.serviceinterface;



import com.network.NetworkConfig;
import com.network.model.Home;
import com.network.model.Status;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

public interface HomeService {

    @GET(NetworkConfig.HOME_API)
    //Call<Home> execHomeApiCall(@Header("x-access-token") String accessToken, @Query("uid") String uid);
    Call<Status> execHomeApiCall();

}
