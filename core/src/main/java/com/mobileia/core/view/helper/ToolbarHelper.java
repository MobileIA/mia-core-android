package com.mobileia.core.view.helper;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Created by matiascamiletti on 27/1/18.
 */

public class ToolbarHelper {
    /**
     * Almacena el activity
     */
    protected AppCompatActivity mActivity;
    /**
     * Almacena el ID de la toolbar
     */
    protected int mResId;

    /**
     * Constructor
     * @param activity
     */
    public ToolbarHelper(AppCompatActivity activity, @IdRes int toolbar){
        // Guardamos activity
        mActivity = activity;
        // Guardamos ID
        mResId = toolbar;
        // Configuramos toolbar
        setUp();
    }

    /**
     * Setea el titulo en la toolbar
     * @param title
     * @return
     */
    public ToolbarHelper setTitle(@StringRes int title){
        // Configurar el titulo
        mActivity.getSupportActionBar().setTitle(title);
        // Devolvemos objeto
        return this;
    }

    /**
     * Setea el titulo en la toolbar
     * @param title
     * @return
     */
    public ToolbarHelper withTitle(String title){
        // Configuramos el titulo
        mActivity.getSupportActionBar().setTitle(title);
        // Devolvemos objeto
        return this;
    }

    /**
     * Configura el boton para volver atras.
     * @return
     */
    public ToolbarHelper withBackButton(){
        // Agregamos boton de flecha para volver
        mActivity.getSupportActionBar().setHomeButtonEnabled(true);
        mActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Devolvemos objeto
        return this;
    }

    /**
     * Funcion que se encarga de configurar la toolbar
     */
    protected void setUp(){
        // Obtenemos toolbar
        Toolbar toolbar = mActivity.findViewById(mResId);
        // Seteamos la nueva Toolbar
        mActivity.setSupportActionBar(toolbar);
    }
}
