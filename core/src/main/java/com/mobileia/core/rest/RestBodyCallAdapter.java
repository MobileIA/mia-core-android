package com.mobileia.core.rest;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * Created by matiascamiletti on 7/8/17.
 */

public interface RestBodyCallAdapter extends CallAdapter<RestBody<?>, Call<RestBody<?>>> {

}
