package com.mobileia.core.rest;

import androidx.annotation.Nullable;

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
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, final Retrofit retrofit) {
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
        // Incluir ese tipo dentro de RestBody
        final Type newResponseType = Types.newParameterizedType(RestBody.class, responseType);
        // Generamos el Adapter
        return new RestBodyCallAdapter() {
            @Override
            public Type responseType() {
                return newResponseType;
            }

            @Override
            public RestBodyCall adapt(Call<RestBody<?>> call) {
                return new RestBodyCall(call, retrofit.callbackExecutor());
            }
        };
    }
}
