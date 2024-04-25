package com.example;

import models.ApiResponse;
import okhttp3.OkHttpClient;
import retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Retrofit nomas necesita un builder que corresponde al cliente que va a llamar, e instanciar el servicio al que va a llamar

public class Main {
    public static void main(String[] args) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder(); //Cliente HTTP

        //Objeto que hace el llamado a la API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/") //URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        ApiService service = retrofit.create(ApiService.class);
        Call<ApiResponse> requestResult = service.getTodo(2); //Llamado al servicio

        // Manejo de excepciones
        try {
            Response<ApiResponse> response = requestResult.execute();
            ApiResponse apiResponse = response.body();

            System.out.println(apiResponse.data.toString());
            //Imprime la respuesta de la llamada, es para validar servicios externos :D
            //Al override el metodo de conversion a string, regreso el string del objeto :D
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}