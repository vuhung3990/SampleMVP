package com.gvn.samplemvp.login;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);

        // alert dialog to show error|success message
        alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setPositiveButton(R.string.ok_button, null);

        // button login
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mButtonLogin.setOnClickListener(this);

        // button register
        mButtonRegister = (Button) findViewById(R.id.button_register);
        mButtonRegister.setOnClickListener(this);

        mPresenter = new LoginPresenter(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                //test case
                //1. check email not null
                String email = mEmail.getText().toString();
                if (email == null) {
                    onError(R.string.email_null);
                    return;
                }
                //2. check email not empty
                if (email.trim().length() == 0) {
                    onError(R.string.email_empty);
                    return;
                }
                //3. email contain @
                if (!email.contains("@")) {
                    onError(R.string.email_invalid_format);
                    return;
                }

                onSuccess(R.string.email_valid);

                break;
            case R.id.button_register:
                break;
            default:
                break;
        }
    }

    private void onSuccess(int resString) {
        alertBuilder.setTitle(R.string.success_title);
        alertBuilder.setMessage(resString);
        alertBuilder.show();
    }

    private void onError(int resString) {
        alertBuilder.setTitle(R.string.error_title);
        alertBuilder.setMessage(resString);
        alertBuilder.show();
    }
}
