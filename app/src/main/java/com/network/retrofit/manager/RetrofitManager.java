package com.network.retrofit.manager;

import android.content.Context;
import android.util.Log;

import com.network.NetworkConfig;
import com.network.controller.LibraryContract;
import com.network.retrofit.rest.api.HomeApi;
import com.network.retrofit.rest.api.MoreApi;
import com.network.retrofit.rest.api.RestApi;
import com.network.retrofit.rest.api.SynopsisApi;
import com.network.subscriber.ResponseSubscriber;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.strmeasy.application.StrmEasyApplication;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by nikita on 8/8/16.
 */
public class RetrofitManager implements LibraryContract {

    private static RetrofitManager retrofitInstance = new RetrofitManager();
    private static Retrofit retrofitClient;
    private HashMap<String, RestApi> restAPIs = new HashMap<String, RestApi>();
    private static final String CACHE_FILE_NAME = "httpcache";

    private RetrofitManager() {
    }

    public static RetrofitManager getInstance() {
        if (retrofitInstance == null) {
            retrofitInstance = new RetrofitManager();
        }
        return retrofitInstance;
    }

    @Override
    public void init(Context context) {

        if (retrofitClient == null) {

            LoggingInterceptor interceptor = new LoggingInterceptor();
            // set your desired log level
            //logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient httpClient = new OkHttpClient();
            // add logging as last interceptor
            httpClient.interceptors().add(interceptor);  // <-- this is the important line!

            /** Enable Cache */
            File httpCache = new File(StrmEasyApplication.getInstance().getCacheDir(), CACHE_FILE_NAME);
            if (httpCache != null) {
                Cache cache = new Cache(httpCache, 10 * 1024 * 1024);
                httpClient.setCache(cache);
            }

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(NetworkConfig.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient);
            //Retrofit.Builder builder = new Retrofit.Builder().baseUrl(NetworkConfig.API_BASE_URL).addConverterFactory(GsonConverterFactory.create());
            retrofitClient = builder.build();
        }

    }

    /**
     * Interceptor which intercepts network traffic and logs the data
     */
    class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            Logger logger = Logger.getLogger("Logging Interceptor");
            logger.info(String.format("StrmEasy ******  Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            logger.info(String.format("StrmEasy ******  Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }

    public Retrofit getRetrofitClient() {
        return retrofitClient;
    }

    private <T extends RestApi> T getRestAPI(Class<? extends RestApi> serviceApi) {
        if (serviceApi == null || restAPIs == null) {
            return null;
        }
        T restApi;
        if ((restApi = (T) restAPIs.get(serviceApi.getCanonicalName())) != null) {
            return restApi;
        }
        return restApi;
    }

    /*@Override
    public void executeHomeApiRequest(String accessToken, String uid, ResponseSubscriber homeApiSubscriber)
    {
        HomeApi homeServiceApi = getRestAPI(HomeApi.class);
        homeServiceApi = new HomeApi(homeApiSubscriber, uid, accessToken);
        restAPIs.put(homeServiceApi.getClass().getCanonicalName(), homeServiceApi);
        homeServiceApi.enqueueRequest();
    }*/

    @Override
    public void executeHomeApiRequest(ResponseSubscriber homeApiSubscriber) {
        HomeApi homeServiceApi = getRestAPI(HomeApi.class);
        homeServiceApi = new HomeApi(homeApiSubscriber);
        restAPIs.put(homeServiceApi.getClass().getCanonicalName(), homeServiceApi);
        homeServiceApi.enqueueRequest();
    }

    @Override
    public void executeSynopsisApiRequest(ResponseSubscriber synopsisApiSubscriber) {
        SynopsisApi synopsisServiceApi = getRestAPI(SynopsisApi.class);
        synopsisServiceApi = new SynopsisApi(synopsisApiSubscriber);
        restAPIs.put(synopsisServiceApi.getClass().getCanonicalName(), synopsisServiceApi);
        synopsisServiceApi.enqueueRequest();
    }

    @Override
    public void executeMoreApiRequest(ResponseSubscriber moreApiSubscriber) {
        MoreApi moreServiceApi = getRestAPI(MoreApi.class);
        moreServiceApi = new MoreApi(moreApiSubscriber);
        restAPIs.put(moreServiceApi.getClass().getCanonicalName(), moreServiceApi);
        moreServiceApi.enqueueRequest();
    }
}
