package cogran.pe.cqsapp.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cogran.pe.cqsapp.R;
import cogran.pe.cqsapp.presenter.PresenterImpl;
import cogran.pe.cqsapp.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    EditText edtusername;
    EditText edtpasword;
    TextView tvLogin;
    Button btnlogin;
    Button btn_signup;

    LoginPresenter mLoginPresenter;


    RelativeLayout rellay1, rellay2;
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusername = findViewById(R.id.edtusername);
        edtpasword = findViewById(R.id.edtpassword);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);


        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(i);
            }
        });

        System.out.println("entro al create");

        mLoginPresenter = new PresenterImpl(LoginActivity.this);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000);

    }

    @Override
    public void onClick(View v) {
        String username = edtusername.getText().toString();
        String password = edtpasword.getText().toString();
        mLoginPresenter.performLogin(username,password);
        System.out.println(username  + " , " + password);
    }

    @Override
    public void loginValidations() {
        Toast.makeText(getApplicationContext(),"Campos vacios", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Intent i = new Intent(getApplicationContext(),profileActivity.class );
        startActivity(i);

        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(), "Error login", Toast.LENGTH_SHORT).show();

    }
}
