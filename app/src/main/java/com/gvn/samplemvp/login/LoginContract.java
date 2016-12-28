package com.gvn.samplemvp.login;

import com.gvn.samplemvp.BasePresenter;

/**
 * Created by Meo on 12/28/2016.
 */

public interface LoginContract {
    interface View {

        String getEmail();

        String getPassword();

        void showErrorEmpty();
    }

    interface Presenter extends BasePresenter {
        void onClickRegister();

        void onClickLogin();
    }
}
