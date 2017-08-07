package com.mobileia.core.rest;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by matiascamiletti on 5/8/17.
 */

public class RestBodyConverter<T> implements Converter<ResponseBody, T> {
    final Converter<ResponseBody, RestBody<T>> delegate;

    RestBodyConverter(Converter<ResponseBody, RestBody<T>> delegate) {
        this.delegate = delegate;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        RestBody<T> envelope = delegate.convert(responseBody);
        return envelope.response;
    }
}