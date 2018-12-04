package cogran.pe.cqsapp.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

import cogran.pe.cqsapp.R;
import cogran.pe.cqsapp.util.CustomViewPager;

import static android.content.ContentValues.TAG;
import static cogran.pe.cqsapp.view.SignupActivity.viewPager;

public class Signup_first_frag extends Fragment{
    View view;



    EditText edt_birthdate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button btnstep1;


    //fragment1
    private EditText nombres;
    private EditText apellidos;
    private EditText fechanac;
    private RadioGroup radioGenGroup;
    private RadioButton radioGenButton;

    SendMessage SM;



    public Signup_first_frag() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_first_fragment, container, false);



        edt_birthdate = (EditText) view.findViewById(R.id.edt_birthdate);
        edt_birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal =  Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int date = cal.get(Calendar.DATE);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "OnDateSet : " + month + "/" + dayOfMonth + "/" + year);
                String date = month + "/" +dayOfMonth + "/" +year;
                edt_birthdate.setText(date);
            }
        };

        return view;


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //fragment1

        radioGenGroup = (RadioGroup) view.findViewById(R.id.rdgroup);
        nombres = (EditText) view.findViewById(R.id.edtname);
        apellidos = (EditText) view.findViewById(R.id.edt_apellidos);
        fechanac = (EditText)view.findViewById(R.id.edt_birthdate);


        btnstep1 = (Button) view.findViewById(R.id.btnstep1);
        btnstep1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                System.out.println("a punto de pasar al paso 2");
                //touchView.setCurre;

                //fragment1
                int selectid = radioGenGroup.getCheckedRadioButtonId();
                radioGenButton = (RadioButton) v.findViewById(selectid);

                String name = nombres.getText().toString().trim();
                String lastnames = apellidos.getText().toString().trim();
                String birthdate = fechanac.getText().toString().trim();


                System.out.println(name + " , " + lastnames + " , " + birthdate + " , " + selectid);
                SM.sendData(name, lastnames, birthdate, String.valueOf(selectid));
                viewPager.setCurrentItem(1);
            }
        });
    }



    public interface SendMessage {
        void sendData(String name, String lastnames, String birthdate, String selectid);
    }


    /*@Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        try {
            SM = (SendMessage) getActivity();

        }catch (ClassCastException e){
            throw new ClassCastException("Error devolviendo la data, ...");
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
