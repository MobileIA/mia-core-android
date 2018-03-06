package com.mobileia.core.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.mobileia.core.R;

/**
 * Created by matiascamiletti on 6/3/18.
 */

public class ConfirmDialog implements MaterialDialog.SingleButtonCallback {
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
        new MaterialDialog.Builder(mContext)
                .title(mTitle)
                .content(mContent)
                .positiveText(R.string.modal_button_positive)
                .negativeText(R.string.modal_button_negative)
                .onPositive(this)
                .show();
    }

    /**
     * Funcion que se ejecuta una vez aceptado el modal
     * @param dialog
     * @param which
     */
    @Override
    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
        mListener.onPositive();
    }

    /**
     * Interfaz para informar sobre la accion del usuario
     */
    public interface OnConfirmDialog{
        void onPositive();
    }
}