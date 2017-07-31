package com.mobileia.core;

import android.os.Build;

/**
 * Created by matiascamiletti on 28/7/17.
 */

public class Mobileia {
    /**
     * Almacena la unica instancia de la libreria
     */
    private static final Mobileia sOurInstance = new Mobileia();
    /**
     * Almacena el APP_ID
     */
    protected int mAppId = 0;
    /**
     * Almacena el Token ID del dispositivo
     */
    protected String mDeviceToken = "";

    /**
     * Obtiene la instancia creada
     * @return
     */
    public static Mobileia getInstance() {
        return sOurInstance;
    }

    private Mobileia() {
    }

    /**
     * Configura el APP_ID
     * @param appId
     */
    public void setAppId(int appId){
        this.mAppId = appId;
    }

    /**
     * Devuelve el APP_ID seteado
     * @return
     */
    public int getAppId(){
        return this.mAppId;
    }

    /**
     * Configura el device token
     * @param token
     */
    public void setDeviceToken(String token){
        this.mDeviceToken = token;
    }

    /**
     * Obtiene el token ID del dispositivo
     * @return
     */
    public String getDeviceToken(){ return this.mDeviceToken; }

    /**
     * Funcion que devuelve el Nombre del dispositivo, con la marca y el modelo
     * @return
     */
    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }
}
