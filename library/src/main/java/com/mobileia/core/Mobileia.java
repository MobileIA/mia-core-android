package com.mobileia.core;

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
}
