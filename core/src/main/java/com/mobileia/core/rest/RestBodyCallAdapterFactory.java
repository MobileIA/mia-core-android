package com.mobileia.core.rest;

import android.support.annotation.Nullable;

import com.google.inject.util.Types;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * Created by matiascamiletti on 7/8/17.
 */

public class RestBodyCallAdapterFactory extends CallAdapter.Factory {

    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        // Verificamos si el tipo de retorno es RestBody
        if (getRawType(returnType) != RestBodyCall.class) {
            return null;
        }
        // Verificar si esta parametrizado
        if (!(returnType instanceof ParameterizedType)) {
            throw new IllegalStateException("RestBody return type must be parameterized"
                    + " as RestBody<Foo> or RestBody<? extends Foo>");
        }
        // Obtener tipo de objeto que se incluyo
        final Type responseType = Utils.getCallResponseType(returnType);
        System.out.println(" CallAdapter Test: " + responseType);
        final Type newResponseType = Types.newParameterizedType(RestBody.class, responseType);
        System.out.println(" CallAdapter Test: " + newResponseType);

        return new RestBodyCallAdapter() {
            @Override
            public Type responseType() {
                return newResponseType;
            }

            @Override
            public Call<RestBody<?>> adapt(Call<RestBody<?>> call) {
                return new RestBodyCall<>(call);
            }
        };
        /*return new CallAdapter<RestBody<?>, Call<RestBody<?>>>() {
            @Override public Type responseType() {
                return newResponseType;
            }

            @Override public Call<RestBody<?>> adapt(Call<RestBody<?>> call) {
                return new RestBodyCall<>(call);
                //return call;
            }
        };*/
    }
}
