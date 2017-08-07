package com.mobileia.core.rest;

import com.mobileia.core.entity.Error;

/**
 * Created by matiascamiletti on 2/8/17.
 */

public class RestBody<T> {
    public boolean success;
    public T response;
    public Error error;
}
