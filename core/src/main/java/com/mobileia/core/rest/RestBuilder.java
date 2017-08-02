package com.mobileia.core.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matiascamiletti on 2/8/17.
 */

abstract public class RestBuilder {
    /**
     * Almacena instancia de Retrofit
     */
    protected Retrofit mRetrofit;

    /**
     * Constructor
     */
    public RestBuilder(){
        // Creamos instancia de retrofit
        mRetrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(createConverterFactory())
                .build();
    }
    /**
     * Crea el servicio de Retrofit
     * @param serviceClass
     * @param <S>
     * @return
     */
    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
    /**
     * Funcion que se encarga de crear el convertor para parsear las fechas en las peticiones
     * @return
     */
    public GsonConverterFactory createConverterFactory(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer()).create();
        return GsonConverterFactory.create(gson);
    }
    /**
     * Obtiene Base URL
     * @return
     */
    abstract public String getBaseUrl();
}
