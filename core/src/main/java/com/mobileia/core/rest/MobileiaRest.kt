package com.mobileia.core.rest

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

abstract public class MobileiaRest {

    protected val retrofit: Retrofit

    constructor(){
        // Creamos instancia de Retrofit
        retrofit = Retrofit.Builder()
                .addConverterFactory(createConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(getBaseUrl())
                .build()
    }

    /**
     * Crea el servicio de Retrofit
     * @param serviceClass
     * @param <S>
     * @return
    </S> */
    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit.create(serviceClass)
    }
    /**
     * Funcion que se encarga de crear el convertor para parsear las fechas en las peticiones
     * @return
     */
    fun createConverterFactory(): GsonConverterFactory {
        val gson = GsonBuilder().registerTypeAdapter(Date::class.java, DateDeserializer()).create()
        return GsonConverterFactory.create(gson)
    }
    /**
     * Obtiene Base URL
     * @return
     */
    abstract fun getBaseUrl(): String
}