package cogran.pe.cqsapp.presenter;

import android.text.TextUtils;


import cogran.pe.cqsapp.service.ApiUtils;
import cogran.pe.cqsapp.service.PersonaService;
import cogran.pe.cqsapp.presenter.LoginPresenter;
import cogran.pe.cqsapp.view.LoginView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PresenterImpl implements LoginPresenter{

    LoginView mLoginView;

    PersonaService personaService;


    public PresenterImpl(LoginView loginView)
    {
        this.mLoginView = loginView;

    }



    @Override
    public void performLogin(String userName, String password) {


        System.out.println("llega presenter" + userName + " , " + password);
        /** Create handle for the RetrofitInstance interface*/

        personaService = ApiUtils.getPersonaService();

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){
            mLoginView.loginValidations();
        }else{
            Call<String> res = personaService.validarLogin(userName, password);
            res.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()){

                        System.out.println("respuestaa   " + response.body());
                        if(response.body().equals("1")){
                            mLoginView.loginSuccess();
                        }else{
                            mLoginView.loginError();
                        }

                    }else{
                       // Toast.makeText(getAp, "Error, please try again", Toast.LENGTH_SHORT);
                        mLoginView.loginError();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    System.out.println("failure >>> " + t);
                    mLoginView.loginError();
                }
            });


            /*if(userName.equals("admin")&& password.equals("admin")){
                mLoginView.loginSuccess();
            }else{
                mLoginView.loginError();
            }*/
        }
    }
}
