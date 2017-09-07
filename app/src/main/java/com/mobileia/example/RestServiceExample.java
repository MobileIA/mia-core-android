package com.mobileia.example;

import android.content.Context;
import android.widget.Toast;

import com.mobileia.core.rest.RestBody;
import com.mobileia.core.rest.RestBodyCall;
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

    public void getServices(final Context context){
        RestService service = createService(RestService.class);
        RestBodyCall<List<Service>> call = service.services2();
        call.enqueue(new Callback<RestBody<List<Service>>>() {
            @Override
            public void onResponse(Call<RestBody<List<Service>>> call, Response<RestBody<List<Service>>> response) {
                System.out.println("Llego");
                if(!response.isSuccessful()){
                    return;
                }

                System.out.println(response.body());
                System.out.println(response.body().response.size());
                //System.out.println(response.body().response.get(0).id);
                Toast.makeText(context, "Esto es una prueba", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RestBody<List<Service>>> call, Throwable t) {

            }
        });
    }

    @Override
    public String getBaseUrl() {
        return "http://banamara.com/api/";
    }
}
