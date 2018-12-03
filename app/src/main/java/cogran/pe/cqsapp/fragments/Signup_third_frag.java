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




    //fragment1
    private EditText nombres;
    private EditText apellidos;
    private EditText fechanac;
    private RadioGroup radioGenGroup;
    private RadioButton radioGenButton;
    //fragment2
    private EditText celular;
    private EditText correo;
    private EditText direccion;
    //fragment3
    private EditText username;
    private EditText password;

    PersonaPresenter mPersonaPresenter;







    public Signup_third_frag() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_third_fragment, container, false);

        btncrearPersona = (Button) view.findViewById(R.id.btnsend);
        btncrearPersona.setOnClickListener(this);
        /*btncrearPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick(v);
            }
        });*/




        //fragment1

        /*radioGenGroup = (RadioGroup) view.findViewById(R.id.rdgroup);
        nombres = (EditText) view.findViewById(R.id.edtname);
        apellidos = (EditText) view.findViewById(R.id.edt_apellidos);
        fechanac = (EditText)view.findViewById(R.id.edt_birthdate);

        //fragment 2
        celular = (EditText)view.findViewById(R.id.edtcelular);
        correo = (EditText)view.findViewById(R.id.edtemail);
        direccion = (EditText) view.findViewById(R.id.edtdireccion);
        //fragment 3
        username = (EditText) view.findViewById(R.id.edtuser);
        password = (EditText) view.findViewById(R.id.edtpass);*/

        mPersonaPresenter = new PersonaPresenterImpl(Signup_third_frag.this);








        return view;
    }

    @Override
    public void onClick(View v) {
        //fragment1
        int selectid = radioGenGroup.getCheckedRadioButtonId();
        radioGenButton = (RadioButton) view.findViewById(selectid);
        String name = nombres.getText().toString();
        String lastnames = apellidos.getText().toString();
        String birthdate = fechanac.getText().toString();
        //fragment 2
        String phone = celular.getText().toString();
        String email = correo.getText().toString();
        String address = direccion.getText().toString();
        //fragment 3
        String user = username.getText().toString();
        String pass = password.getText().toString();


        System.out.println("datos recibidos :: " + selectid + " , " + name + " , " + lastnames + " , " + birthdate + " , " + phone + " , " + email + " , " + address + " , " + user + " , " + pass);

        mPersonaPresenter.crearPersona(name, lastnames, "Granados", "18", birthdate, "123456", phone, email, String.valueOf(selectid), "ORH",
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
}
