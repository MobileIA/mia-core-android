package com.mobileia.example;

import com.mobileia.core.rest.RestBody;
import com.mobileia.core.rest.RestBuilder;
import com.mobileia.example.entity.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by matiascamiletti on 2/8/17.
 */

public class RestServiceExample extends RestBuilder {

    public void getServices(){
        RestService service = createService(RestService.class);
        Call<RestBody<List<Service>>> call = service.services();
        call.enqueue(new Callback<RestBody<List<Service>>>() {
            @Override
            public void onResponse(Call<RestBody<List<Service>>> call, Response<RestBody<List<Service>>> response) {
                System.out.println("Llego");
                if(!response.isSuccessful()){
                    return;
                }

                System.out.println(response.body().success);
                System.out.println(response.body().response);
            }

            @Override
            public void onFailure(Call<RestBody<List<Service>>> call, Throwable t) {
                System.out.println("Error " + t.getMessage());
            }
        });
    }

    @Override
    public String getBaseUrl() {
        return "http://banamara.com/api/";
    }
}
