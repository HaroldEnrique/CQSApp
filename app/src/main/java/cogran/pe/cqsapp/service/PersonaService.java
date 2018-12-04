package cogran.pe.cqsapp.service;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonaService {

    /**
     * URL MANIPULATION
     * Using Query parameters.
     * */
    @GET("validarLogin/{username}/{password}")
    Call<String> validarLogin(@Path("username") String username, @Path("password") String password);

    @POST("pais/{id}/createPersonaUsuario")
    @FormUrlEncoded
    Call<ResponseBody> crearPersona(@Path("id") String idpais, @Field("nombre") String nombres,
                                    @Field("apMaterno") String apMaterno,
                                    @Field("apPaterno") String apPaterno,
                                    @Field("edad") String edad,
                                    @Field("fechaNac") String fechaNac,
                                    @Field("Nudoc") String Nudoc,
                                    @Field("celular") String celular,
                                    @Field("correo") String correo,
                                    @Field("genero") String genero,
                                    @Field("tiSangre") String tiSangre,
                                    @Field("fotoPerfil") String fotoPerfil,
                                    @Field("descripcion") String descripcion,
                                    @Field("usuario") String usuario,
                                    @Field("password") String password);
}
