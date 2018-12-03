package cogran.pe.cqsapp.presenter;

import android.text.TextUtils;

import cogran.pe.cqsapp.service.ApiUtils;
import cogran.pe.cqsapp.service.PersonaService;
import cogran.pe.cqsapp.view.SignupView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonaPresenterImpl implements PersonaPresenter {


    SignupView signupView;

    PersonaService personaService;

    public PersonaPresenterImpl(SignupView signupView) {
        this.signupView = signupView;
    }


    @Override
    public void crearPersona(String nombre, String apMaterno, String apPaterno, String edad, String fechanac, String nudoc, String celular, String correo, String genero, String tiSangre, String fotoperfil, String descripcion, String usuario, String password) {

        personaService = ApiUtils.getPersonaService();
        if(TextUtils.isEmpty(nombre) || TextUtils.isEmpty(apMaterno)){
            signupView.signupvalidations();
        }else{
            Call<ResponseBody> res = personaService.crearPersona(nombre, apMaterno,apPaterno, edad, fechanac, nudoc, celular, correo, genero, tiSangre, fotoperfil, descripcion, usuario, password);
            res.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){

                        System.out.println("respuestaa crear   " + response.body());
                        /*if(response.body().equals("1")){
                            signupView.createSuccess();
                        }else{
                            System.out.println("failure response body  1111 >>> " );
                            signupView.createError();
                        }*/

                    }else{
                        // Toast.makeText(getAp, "Error, please try again", Toast.LENGTH_SHORT);
                        signupView.createError();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    System.out.println("failure response body>>> " + t);
                    signupView.createError();
                }
            });
        }

    }



}
