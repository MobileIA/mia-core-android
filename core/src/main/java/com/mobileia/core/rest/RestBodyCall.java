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

public class RestBodyCall<T> implements Call<RestBody<T>> {

    protected Call<RestBody<T>> mDelegate;

    public RestBodyCall(Call<RestBody<T>> delegate){
        this.mDelegate = delegate;
    }

    @Override
    public Response<RestBody<T>> execute() throws IOException {
        return mDelegate.execute();
    }

    @Override
    public void enqueue(Callback<RestBody<T>> callback) {
        mDelegate.enqueue(callback);
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
    public Call<RestBody<T>> clone() {
        return new RestBodyCall(mDelegate.clone());
    }

    @Override
    public Request request() {
        return mDelegate.request();
    }
}
