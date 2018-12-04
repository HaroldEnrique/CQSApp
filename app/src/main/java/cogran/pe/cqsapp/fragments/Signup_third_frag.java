package cogran.pe.cqsapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cogran.pe.cqsapp.R;
import cogran.pe.cqsapp.presenter.PersonaPresenter;
import cogran.pe.cqsapp.presenter.PersonaPresenterImpl;
import cogran.pe.cqsapp.view.SignupActivity;
import cogran.pe.cqsapp.view.SignupView;
import cogran.pe.cqsapp.view.profileActivity;

public class Signup_third_frag extends Fragment implements View.OnClickListener, SignupView {

    View view;
    private Button btncrearPersona;


    //fragment3
    private EditText username;
    private EditText password;

    PersonaPresenter mPersonaPresenter;


    //stored variables
    private String pri_celular;
    private String pri_correo;
    private String pri_direccion;

    private String pri_name;
    private String pri_lastnames;
    private String pri_birthdate;
    private String pri_selectid;


    public Signup_third_frag() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_third_fragment, container, false);

        btncrearPersona = (Button) view.findViewById(R.id.btnsend);
        btncrearPersona.setOnClickListener(this);


        //fragment 3
        username = (EditText) view.findViewById(R.id.edtuser);
        password = (EditText) view.findViewById(R.id.edtpass);

        mPersonaPresenter = new PersonaPresenterImpl(Signup_third_frag.this);


        return view;
    }

    @Override
    public void onClick(View v) {


        //fragment 3
        String user = username.getText().toString();
        String pass = password.getText().toString();


        System.out.println("datos recibidos :: " + pri_selectid + " , " + pri_name + " , " + pri_lastnames + " , " + pri_birthdate + " , " + pri_celular + " , " + pri_correo + " , " + pri_direccion + " , " + user + " , " + pass);

        mPersonaPresenter.crearPersona("PAIS_023",pri_name, pri_lastnames, "Granados", "18", pri_birthdate, "123456", pri_celular, pri_correo, String.valueOf(pri_selectid), "ORH",
                "laksdjfl", "asldf", user, pass);
    }

    @Override
    public void signupvalidations() {
        Toast.makeText(getContext(),"Campos vacios en los fragmentos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createSuccess() {
        Intent i = new Intent(getContext(),profileActivity.class );
        startActivity(i);

        Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createError() {
        Toast.makeText(getContext(), "Error en la inscripción", Toast.LENGTH_SHORT).show();
    }


    public void receivedFromFragment2(String name, String lastnames, String birthdate, String selectid, String celular, String correo, String direccion ){
        System.out.println("reciviendo frag 3" + name + " , " + lastnames + " , " + birthdate + " , " + selectid + " , " + celular + " , " + correo + " , " +direccion);
        pri_celular = celular;
        pri_correo = correo;
        pri_direccion = direccion;

        pri_name = name;
        pri_lastnames = lastnames;
        pri_birthdate = birthdate;
        pri_selectid = selectid;
    }

}
