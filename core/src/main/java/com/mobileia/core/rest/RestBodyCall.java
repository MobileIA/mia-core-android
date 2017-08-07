package com.mobileia.core.rest;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by matiascamiletti on 7/8/17.
 */

public class RestBodyCall<T> implements Call<T> {

    protected Call<T> mDelegate;

    public RestBodyCall(Call<T> delegate){
        this.mDelegate = delegate;
    }

    @Override
    public Response<T> execute() throws IOException {
        return mDelegate.execute();
    }

    @Override
    public void enqueue(Callback<T> callback) {
        mDelegate.enqueue(callback);
    }

    public void async(final Callback<RestBody<T>> callback){
        mDelegate.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                Response<RestBody<T>> restBody = (Response<RestBody<T>>)response;
                callback.onResponse(null, restBody);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                callback.onFailure(null, t);
            }
        });
    }

    @Override
    public boolean isExecuted() {
        return mDelegate.isExecuted();
    }

    @Override
    public void cancel() {
        mDelegate.cancel();
    }

    @Override
    public boolean isCanceled() {
        return mDelegate.isCanceled();
    }

    @Override
    public Call<T> clone() {
        return new RestBodyCall<>(mDelegate.clone());
    }

    @Override
    public Request request() {
        return mDelegate.request();
    }
}
