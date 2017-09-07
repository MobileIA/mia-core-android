package com.mobileia.core.rest;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by matiascamiletti on 7/8/17.
 */

public class RestBodyCall<T> implements Call<RestBody<T>> {

    protected Call<RestBody<T>> mDelegate;

    protected Executor mExecutor;

    public RestBodyCall(Call<RestBody<T>> delegate){
        this.mDelegate = delegate;
    }

    public RestBodyCall(Call<RestBody<T>> delegate, Executor executor){
        this.mDelegate = delegate;
        this.mExecutor = executor;
    }

    @Override
    public Response<RestBody<T>> execute() throws IOException {
        return mDelegate.execute();
    }

    @Override
    public void enqueue(final Callback<RestBody<T>> callback) {
        // Ejecutar en el Thread por defecto de Retrofit
        mDelegate.enqueue(new Callback<RestBody<T>>() {
            @Override
            public void onResponse(final Call<RestBody<T>> call, final Response<RestBody<T>> response) {
                mExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResponse(call, response);
                    }
                });
            }

            @Override
            public void onFailure(final Call<RestBody<T>> call, final Throwable t) {
                mExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(call, t);
                    }
                });
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
    public Call<RestBody<T>> clone() {
        return new RestBodyCall(mDelegate.clone());
    }

    @Override
    public Request request() {
        return mDelegate.request();
    }
}
