package cogran.pe.cqsapp.fragments;

import android.app.DatePickerDialog;
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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

import cogran.pe.cqsapp.R;

import static android.content.ContentValues.TAG;

public class Signup_first_frag extends Fragment{
    View view;

    EditText edt_birthdate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button btnstep1;


    public Signup_first_frag() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_first_fragment, container, false);
        final View touchView = view.findViewById(R.id.viewpager_id);
        btnstep1 = (Button) view.findViewById(R.id.btnstep1);
        btnstep1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                System.out.println("a punto de pasar al paso 2");
                //touchView.setCurre;
            }
        });
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



}
