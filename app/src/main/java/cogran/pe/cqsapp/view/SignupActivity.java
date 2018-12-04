package cogran.pe.cqsapp.view;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cogran.pe.cqsapp.R;
import cogran.pe.cqsapp.fragments.Signup_first_frag;
import cogran.pe.cqsapp.fragments.Signup_second_frag;
import cogran.pe.cqsapp.fragments.Signup_third_frag;
import cogran.pe.cqsapp.presenter.PersonaPresenter;
import cogran.pe.cqsapp.presenter.PersonaPresenterImpl;
import cogran.pe.cqsapp.util.CustomViewPager;

public class SignupActivity extends AppCompatActivity implements Signup_first_frag.SendMessage , Signup_second_frag.SendMessageTwo  {



    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    public static CustomViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (CustomViewPager) findViewById(R.id.viewpager_id);

        Signup_view_page_adapter adapter = new Signup_view_page_adapter(getSupportFragmentManager());
        adapter.AddFragment(new Signup_first_frag(), "First");
        adapter.AddFragment(new Signup_second_frag(), "Second");
        adapter.AddFragment(new Signup_third_frag(), "third");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        LinearLayout tabStrip = ((LinearLayout)tabLayout.getChildAt(0));
        for(int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }


        viewPager.setPagingEnabled(false);

        /*final View touchView = findViewById(R.id.viewpager_id);
        touchView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });*/



    }


   @Override
    public void sendData(String name, String lastnames, String birthdate, String selectid) {
        String tag = "android:switcher:" + R.id.viewpager_id + ":" + 1;
       System.out.println("tagg send data > " +tag);
        Signup_second_frag f = (Signup_second_frag) getSupportFragmentManager().findFragmentByTag(tag);
        f.receivedFromFragment1(name, lastnames, birthdate, selectid);
    }

    @Override
    public void sendDataTwo(String name, String lastnames, String birthdate, String selectid, String celular, String correo, String direccion) {
        String tag = "android:switcher:" + R.id.viewpager_id + ":" + 2;
        System.out.println("tagg send data two> " +tag);
        Signup_third_frag t= (Signup_third_frag) getSupportFragmentManager().findFragmentByTag(tag);
        t.receivedFromFragment2(name, lastnames, birthdate, selectid, celular, correo, direccion);
    }
}
