package com.mobileia.core.dialog;

import android.content.Context;
import android.support.annotation.StringRes;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mobileia.core.R;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/**
 * Created by matiascamiletti on 6/3/18.
 */

public class ConfirmDialog {
    /**
     * Almacena el contexto
     */
    protected Context mContext;
    /**
     * almacena el titulo del modal
     */
    protected int mTitle;
    /**
     * almacena el texto del modal
     */
    protected int mContent;
    /**
     * El listener que informara si se acepto el modal
     */
    protected OnConfirmDialog mListener;

    /**
     * Constructor
     * @param context
     * @param title
     * @param content
     */
    public ConfirmDialog(Context context, @StringRes int title, @StringRes int content){
        mContext = context;
        mTitle = title;
        mContent = content;
    }

    /**
     * Funcion que ejecuta el modal
     * @param listener
     */
    public void show(OnConfirmDialog listener){
        mListener = listener;
        new MaterialDialog(mContext)
                .title(mTitle, "")
                .message(mContent, "", false, 1f)
                .positiveButton(null, "Si", new Function1<MaterialDialog, Unit>() {
                    @Override
                    public Unit invoke(MaterialDialog materialDialog) {
                        mListener.onPositive();
                        return null;
                    }
                })
                .negativeButton(null, "No", null)
                .show();
    }

    /**
     * Interfaz para informar sobre la accion del usuario
     */
    public interface OnConfirmDialog{
        void onPositive();
    }
}