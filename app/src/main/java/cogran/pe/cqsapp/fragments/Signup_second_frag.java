package cogran.pe.cqsapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import cogran.pe.cqsapp.R;

import static cogran.pe.cqsapp.view.SignupActivity.viewPager;

public class Signup_second_frag extends Fragment {

    View view;

    Button btnstep2;


    //stored variables
    private String pri_name;
    private String pri_lastnames;
    private String pri_birthdate;
    private String pri_selectid;


    //fragment2
    private EditText celular;
    private EditText correo;
    private EditText direccion;

    SendMessageTwo SM2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_second_fragment, container, false);

        celular = (EditText)view.findViewById(R.id.edtcelular);
        correo = (EditText)view.findViewById(R.id.edtemail);
        direccion = (EditText) view.findViewById(R.id.edtdireccion);

        btnstep2 = (Button) view.findViewById(R.id.btnstep2);
        btnstep2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                System.out.println("a punto de pasar al paso 3");

                String phone = celular.getText().toString();
                String email = correo.getText().toString();
                String address = direccion.getText().toString();
                SM2.sendDataTwo(pri_name, pri_lastnames, pri_birthdate, pri_selectid,  phone,email,address);
                viewPager.setCurrentItem(2);
            }
        });

        return view;
    }


    public interface SendMessageTwo {
        void sendDataTwo(String name, String lastnames, String birthdate, String selectid, String celular, String correo, String direccion);
    }


    /*@Override
    public void sendData(String name, String lastnames, String birthdate, String selectid) {
        System.out.println(name + " , " + lastnames + " , " + birthdate + " , " + selectid);
        pri_name = name;
        pri_lastnames = lastnames;
        pri_birthdate = birthdate;
        pri_selectid = selectid;
    }*/



    public void receivedFromFragment1(String name, String lastnames, String birthdate, String selectid ){
        System.out.println("reciviendo frag 2" + name + " , " + lastnames + " , " + birthdate + " , " + selectid);
        pri_name = name;
        pri_lastnames = lastnames;
        pri_birthdate = birthdate;
        pri_selectid = selectid;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM2 = (SendMessageTwo) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again frag 2");
        }
    }

}
