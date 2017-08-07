package com.mobileia.example;

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

    public void getServices(){
        RestService service = createService(RestService.class);
        RestBodyCall<List<Service>> call = service.services2();
        call.async(new Callback<RestBody<List<Service>>>() {
            @Override
            public void onResponse(Call<RestBody<List<Service>>> call, Response<RestBody<List<Service>>> response) {
                System.out.println("Llego");
                if(!response.isSuccessful()){
                    return;
                }

                System.out.println(response.body());
                System.out.println(response.body().response.size());
                System.out.println(response.body().response.get(0).id);
            }

            @Override
            public void onFailure(Call<RestBody<List<Service>>> call, Throwable t) {

            }
        });
        /*call.enqueue(new Callback<List<Service>>() {
            @Override
            public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {
                System.out.println("Llego");
                if(!response.isSuccessful()){
                    return;
                }

                RestBody<List<Service>> restBody = (RestBody<List<Service>>)response.body();
                System.out.println(restBody);
                System.out.println(restBody.response.size());
                System.out.println(restBody.response.get(0).id);
            }

            @Override
            public void onFailure(Call<List<Service>> call, Throwable t) {

            }
        });*/
        /*call.enqueue(new Callback<RestBody<List<Service>>>() {
            @Override
            public void onResponse(Call<RestBody<List<Service>>> call, Response<RestBody<List<Service>>> response) {
                System.out.println("Llego");
                if(!response.isSuccessful()){
                    return;
                }

                System.out.println(response.body());
                System.out.println(response.body().response.size());
                System.out.println(response.body().response.get(0).id);
            }

            @Override
            public void onFailure(Call<RestBody<List<Service>>> call, Throwable t) {

            }
        });*/
        /*Call<List<Service>> call = service.services();
        call.enqueue(new Callback<List<Service>>() {
            @Override
            public void onResponse(Call<List<Service>> call, Response<List<Service>> response) {
                System.out.println("Llego");
                if(!response.isSuccessful()){
                    return;
                }

                System.out.println(response.body());
                System.out.println(response.body().size());
                System.out.println(response.body().get(0).id);
                //System.out.println(response.body().response);
            }

            @Override
            public void onFailure(Call<List<Service>> call, Throwable t) {
                System.out.println("Error " + t.getMessage());
            }
        });*/
    }

    @Override
    public String getBaseUrl() {
        return "http://banamara.com/api/";
    }
}
