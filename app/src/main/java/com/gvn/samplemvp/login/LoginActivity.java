package com.gvn.samplemvp.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gvn.samplemvp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private EditText mEmail;
    private EditText mPassword;
    private Button mButtonLogin;
    private Button mButtonRegister;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(this);
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonRegister.setOnClickListener(this);

        mPresenter = new LoginPresenter(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                mPresenter.onClickLogin();
                break;
            case R.id.button_register:
                mPresenter.onClickRegister();
                break;
            default:
                break;
        }
    }

    @Override
    public String getEmail() {
        return mEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void showErrorEmpty() {
        Log.d("aaaa", "showErrorEmpty: ");
    }
}
