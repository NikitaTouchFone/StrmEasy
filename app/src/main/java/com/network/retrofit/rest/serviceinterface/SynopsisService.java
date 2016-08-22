package com.network.retrofit.rest.serviceinterface;

import com.network.NetworkConfig;
import com.network.model.Status;
import com.network.model.SynopsisStatus;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by nikita on 17/8/16.
 */
public interface SynopsisService   {

    @GET(NetworkConfig.SYNOPSIS_API)
    Call<SynopsisStatus> execSynopsisApiCall();
}
