package com.mobileia.core.rest;


import androidx.annotation.Nullable;

import com.google.inject.util.Types;

import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by matiascamiletti on 5/8/17.
 */

class RestBodyConverterFactory extends Converter.Factory {

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, java.lang.annotation.Annotation[] annotations, Retrofit retrofit) {
        Type restBodyType = Types.newParameterizedType(RestBody.class, type);
        Converter<ResponseBody, RestBody> delegate = retrofit.nextResponseBodyConverter(this, restBodyType, annotations);
        return new RestBodyConverter(delegate);
    }

}