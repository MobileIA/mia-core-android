package com.mobileia.core.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by matiascamiletti on 27/2/18.
 */

public class LocalBroadcastHelper {

    /**
     * Envia el intent con la informacion al broadcast
     * @param context
     * @param intent
     */
    public static void send(Context context, Intent intent){
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /**
     * Inicia el broadcast especifico
     * @param context
     * @param broadcastReceiver
     * @param action
     */
    public static void start(Context context, BroadcastReceiver broadcastReceiver, String action){
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, new IntentFilter(action));
    }
    /**
     * Funcion que pone en stop el Broadcast
     * @param context
     * @param broadcastReceiver
     */
    public static void stop(Context context, BroadcastReceiver broadcastReceiver){
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
    }
}
