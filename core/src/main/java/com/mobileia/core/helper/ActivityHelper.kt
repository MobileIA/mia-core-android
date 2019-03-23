package com.mobileia.core.helper

import android.content.Intent.getIntent
import androidx.core.app.NotificationCompat.getExtras
import android.app.Activity
import android.content.Intent



open class ActivityHelper {

    companion object {
        fun createInstance(context: Activity, cls: Class<*>) {
            val intent = Intent(context, cls)
            context.startActivity(intent)
        }

        fun createInstance(context: Activity, intent: Intent) {
            context.startActivity(intent)
        }

        fun createInstanceClearTop(context: Activity, cls: Class<*>) {
            val intent = Intent(context, cls)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }

        fun getExtraIntent(context: Activity, key: String): Any? {
            // Verificamos que haya parametros
            return if (context.intent.extras == null || context.intent.extras!!.isEmpty) {
                null
            } else context.intent.extras!!.get(key)
            // Retornamos el valor buscado
        }
    }

}