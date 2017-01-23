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

    @Override
    public void onClickLogin(String email) {
        //test case
        //1. check email not null
        if (email == null) {
            view.onError(R.string.email_null);
            return;
        }
        //2. check email not empty
        if (email.trim().length() == 0) {
            view.onError(R.string.email_empty);
            return;
        }
        //3. email contain @
        if (!email.contains("@")) {
            view.onError(R.string.email_invalid_format);
            return;
        }

        view.onSuccess(R.string.email_valid);
    }
}
