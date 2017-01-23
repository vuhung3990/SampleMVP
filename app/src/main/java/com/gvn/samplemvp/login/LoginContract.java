package com.gvn.samplemvp.login;

import com.gvn.samplemvp.BasePresenter;

/**
 * Created by Meo on 12/28/2016.
 */

public interface LoginContract {
    public interface View {
        void onError(int resString);

        void onSuccess(int resString);

        String getEmail();
    }

    interface Presenter extends BasePresenter {
        void onClickLogin();
    }

    interface Repository {
    }
}
