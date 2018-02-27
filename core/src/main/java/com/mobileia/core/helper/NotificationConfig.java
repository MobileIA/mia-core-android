package com.mobileia.core.helper;

import android.app.PendingIntent;
import android.graphics.Color;

import com.mobileia.core.R;

/**
 * Created by matiascamiletti on 27/2/18.
 */

public class NotificationConfig {

    /**
     * Almacena el canal por defecto
     */
    public static String sChannel = "channel_default";
    /**
     * Almacena el nombre del canal
     */
    public static String sChannelName = "Canal por defecto";
    /**
     * Almacena el color del icono de la notificacion
     */
    public static int sColor = Color.RED;
    /**
     * Almacena el PendingIntent por default
     */
    public static PendingIntent sPendingIntent;
    /**
     * Almacena el ID por default
     */
    public static int sId = 1;
    /**
     * Almacena el Icono por default
     */
    public static int sIcon = R.drawable.ic_notifications_black_24dp;
    /**
     * Almacena el iD de la notificacion
     */
    public int id;
    /**
     * Almacena el canal de la notificacion
     */
    public String channel;
    /**
     * almacena el nombre del canal
     */
    public String channelName;
    /**
     *  Almacena el color de la notificacion
     */
    public int color;
    /**
     * Almacena el pendingIntent
     */
    public PendingIntent pendingIntent;
    /**
     * Almacena el icono de la notificacion
     */
    public int icon;

    /**
     * Genera una configuracion por defecto
     * @return
     */
    public static NotificationConfig getDefault(){
        NotificationConfig config = new NotificationConfig();
        config.id = sId;
        config.channel = sChannel;
        config.channelName = sChannelName;
        config.color = sColor;
        config.pendingIntent = sPendingIntent;
        config.icon = sIcon;
        return config;
    }

    /**
     * Funcion para configurar los valores por defecto de las notificaciones
     * @param channel
     * @param channelName
     * @param color
     */
    public static void setUp(String channel, String channelName, int color, int icon, PendingIntent pIntent){
        // Almacenamos el canal
        sChannel = channel;
        sChannelName = channelName;
        // Almacenamos el color
        sColor = color;
        // Almacenamos el pendingIntent
        sPendingIntent = pIntent;
        // Almacenamos el icono
        sIcon = icon;
    }

}
