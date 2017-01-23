package com.gvn.samplemvp.login;

import com.gvn.samplemvp.BasePresenter;

/**
 * Created by Meo on 12/28/2016.
 */

public interface LoginContract {
    interface View {
        /**
         * display error alert
         * @param resString string resource to display
         */
        void onError(int resString);

        /**
         * display message success
         * @param resString string resource to display
         */
        void onSuccess(int resString);
    }

    interface Presenter extends BasePresenter {
        /**
         * event click button login
         * @param email pass email to check format
         */
        void onClickLogin(String email);
    }

    interface Repository {
    }
}
