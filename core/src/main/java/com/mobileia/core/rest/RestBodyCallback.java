package com.mobileia.core.rest;

import com.mobileia.core.entity.Error;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

abstract public class RestBodyCallback<T> implements Callback<RestBody<T>> {

    @Override
    public void onResponse(Call<RestBody<T>> call, Response<RestBody<T>> response) {
        // Verificar si la respuesta fue incorrecta
        if (!response.isSuccessful() || !response.body().success) {
            // Verificar si hubo un error y no se pudo obtener respuesta correcta del servidor
            if(response.body() == null){
                onError(new Error(-2, "Error Inesperado!"));
            }else{
                onError(response.body().error);
            }
            return;
        }
        // Enviamos que se obtuvo respuesta correctamente
        onSuccess(response.body().response);
    }

    @Override
    public void onFailure(Call<RestBody<T>> call, Throwable t) {
        onError(new Error(-3, t.getMessage()));
    }

    abstract public void onSuccess(T body);
    abstract public void onError(Error error);
}