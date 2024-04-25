package retrofit;
import models.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

//No olvidar que retrofit transforma las llamas a una API en interfaces que procesan las respuestas

public interface ApiService {
    @GET("/api/users/{id}") // Peticion a la ruta
    Call<ApiResponse> getTodo(@Path("id") long id); // Resultado que se espera
}
