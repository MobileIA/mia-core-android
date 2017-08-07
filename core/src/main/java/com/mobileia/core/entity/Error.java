package com.mobileia.core.entity;

/**
 * Created by matiascamiletti on 7/8/17.
 */

public class Error {
    /**
     * Codigo de error cuando no esta registrado el usuario
     */
    public static final int CODE_USER_NOT_REGISTERED = 414;
    /**
     * Almacena el codigo del error
     */
    public int code;
    /**
     * Almacena el mensaje de error
     */
    public String message;

    /**
     * Constructor
     * @param code
     * @param message
     */
    public Error(int code, String message){
        this.code = code;
        this.message = message;
    }
}
