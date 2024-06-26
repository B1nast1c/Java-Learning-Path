package retrofit;
import models.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

//No olvidar que retrofit transforma las llamas a una API en interfaces que procesan las respuestas
//Retrofit SOLAMENTE LLAMA A LA API O SERVICIO REST

public interface ApiService {
    @GET("/api/users/{id}") // Peticion a la ruta (SE ADJUNTA A LA RUTA BASE)
    Call<ApiResponse> getTodo(@Path("id") long id); // Resultado que se espera
}
