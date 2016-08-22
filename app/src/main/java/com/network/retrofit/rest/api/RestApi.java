package com.network.retrofit.rest.api;

import android.util.Log;

import com.google.gson.JsonSyntaxException;
import com.network.model.RestError;
import com.network.subscriber.ResponseSubscriber;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Converter;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Base class encapsulating common REST API services.
 * Created by Touchfone on 11/12/2015.
 */
public class RestApi {
    protected Call client;
    private ResponseSubscriber subscriber;

    RestApi(ResponseSubscriber subscriber) {
        this.subscriber = subscriber;
    }

    /**
     * Cancel the current enqueued request
     */
    protected void cancel() {
        if (client != null) {
            client.cancel();
        }
    }

    /**
     * Retry the current request
     */
    protected void retry() {
        if (client != null) {
            client = client.clone();
        }
        enqueueRequest();
    }

    /**
     * Queue the current request on the network thread scheduler configured by the Retrofit library. Once the request is executed, the response is delivered to a registered subscriber.
     */
    protected void enqueueRequest() {
        {
            if (subscriber == null) {
                return;
            }
            client.enqueue(new Callback() {
                @Override
                public void onResponse(Response response, Retrofit retrofit) {
                    try {
                        Log.d("StrmEasy *** RestApi", "Response raw()--" + response.raw());
                        Log.d("StrmEasy *** RestApi", "Response code--" + response.code());
                        Log.d("StrmEasy *** RestApi", "Response body --" + response.body());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (response == null) {
                    } else if (response != null) {
                        Map<String, List<String>> headers = response.headers().toMultimap();
                        subscriber.onResponseHeaders(headers);
                        if (response.isSuccess()) { // 2xx HTTP response code
                            subscriber.onSuccess(response.body());
                            //2xx ok success
                        } else {
                            //4xx HTTP response code
                            Converter<ResponseBody, RestError> errorConverter = retrofit.responseConverter(RestError.class, new Annotation[0]);

                            try {
                                RestError error = errorConverter.convert(response.errorBody());

                                subscriber.onFailure(error);
                            } catch (IOException e) {
                                e.printStackTrace();
                                subscriber.onFailure(e);
                            } catch (JsonSyntaxException e) {
                                //Request url not correct
                                e.printStackTrace();
                                subscriber.onFailure(e);
                            } catch (IllegalStateException e) {
                                e.printStackTrace();
                                subscriber.onFailure(e);
                            } catch (NullPointerException npte) {
                                npte.printStackTrace();
                                subscriber.onFailure(npte);
                            } catch (Exception e) {
                                e.printStackTrace();
                                subscriber.onFailure(e);
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    // Network connectivity issue
                    subscriber.onFailure(t);
                }
            });
        }

    }
}
