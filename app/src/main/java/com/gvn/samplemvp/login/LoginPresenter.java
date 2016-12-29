package com.gvn.samplemvp.login;

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
    public void onClickRegister() {

    }

    public static boolean isStringNotEmptyOrNull(String s) {
        return s != null && s.trim().length() > 0;
    }

    @Override
    public void onClickLogin() {
        if (!isStringNotEmptyOrNull(view.getEmail()) && !isStringNotEmptyOrNull(view.getPassword())) {

        } else {
            view.showErrorEmpty();
        }
    }
}
