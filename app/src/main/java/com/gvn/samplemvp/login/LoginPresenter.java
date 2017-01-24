package com.gvn.samplemvp.login;

import com.gvn.samplemvp.R;

/**
 * Created by Meo on 12/28/2016.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unSubscribe() {
    }

    public boolean isValidEmail(String email) {
        //test case
        //1. check email not null
        if (email == null) {
            view.onError(R.string.email_null);
            return false;
        }
        //2. check email not empty
        if (email.trim().length() == 0) {
            view.onError(R.string.email_empty);
            return false;
        }
        //3. email contain @
        if (!email.contains("@")) {
            view.onError(R.string.email_invalid_format);
            return false;
        }
        return true;
    }

    @Override
    public void onClickLogin(String email) {
        if (isValidEmail(email))
            view.onSuccess(R.string.email_valid);
    }
}
