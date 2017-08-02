package com.mobileia.example;

import com.mobileia.core.rest.RestBody;
import com.mobileia.example.entity.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by matiascamiletti on 2/8/17.
 */

public interface RestService {
    @POST("company/services")
    Call<RestBody<List<Service>>> services();
}
