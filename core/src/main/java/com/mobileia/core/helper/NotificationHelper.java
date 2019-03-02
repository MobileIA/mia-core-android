package com.mobileia.core.helper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;

/**
 * Created by matiascamiletti on 27/2/18.
 */

public class NotificationHelper extends ContextWrapper {
    /**
     * Almacena instancia del manager
     */
    protected NotificationManager mNotifManager;
    /**
     * Almacena el objeto que tiene la configuracion de la notificacion
     */
    protected NotificationConfig mConfig;

    /**
     * Constructor
     * @param base
     */
    public NotificationHelper(Context base) {
        // configuramos padre
        super(base);
        // Generar configuracion por default
        mConfig = NotificationConfig.getDefault();
        // Configurar canales si fuera necesario
        setUpChannel();
    }
    /**
     * Constructor
     * @param base
     */
    public NotificationHelper(Context base, NotificationConfig config) {
        // configuramos padre
        super(base);
        // Almacenar configuracion
        mConfig = config;
        // Configurar canales si fuera necesario
        setUpChannel();
    }
    /**
     * Envia una notificacion con String values
     * @param title
     * @param message
     */
    public void send(String title, @StringRes int message){
        send(title, getApplicationContext().getResources().getString(message));
    }
    /**
     * Envia una notificacion con String values
     * @param title
     * @param message
     */
    public void send(@StringRes int title, String message){
        send(getApplicationContext().getResources().getString(title), message);
    }
    /**
     * Envia una notificacion con String values
     * @param title
     * @param message
     */
    public void send(@StringRes int title, @StringRes int message){
        send(getApplicationContext().getResources().getString(title), getApplicationContext().getResources().getString(message));
    }
    /**
     * Envia una notificacion
     * @param title
     * @param message
     */
    public void send(String title, String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, mConfig.channel)
                .setSmallIcon(mConfig.icon)
                .setContentTitle(title)
                .setContentText(message)
                .setColor(mConfig.color)
                .setAutoCancel(true)
                .setContentIntent(mConfig.pendingIntent);
        notify(mConfig.id, builder);
    }
    /**
     * Publica una notificacion
     * @param id
     * @param notification
     */
    public void notify(int id, NotificationCompat.Builder notification) {
        getManager().notify(id, notification.build());
    }
    /**
     * Configura los canales en Android Oreo
     */
    protected void setUpChannel()
    {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(mConfig.channel, mConfig.channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(mConfig.color);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            setUpNotificationChannel(notificationChannel);
        }
    }
    /**
     * Funcion para crear un canal en la API 26
     * @param channel
     */
    protected void setUpNotificationChannel(NotificationChannel channel)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getManager().createNotificationChannel(channel);
        }
    }
    /**
     * Devuelve el manager de las notificaciones
     * @return
     */
    protected NotificationManager getManager() {
        if (mNotifManager == null) {
            mNotifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mNotifManager;
    }
}
