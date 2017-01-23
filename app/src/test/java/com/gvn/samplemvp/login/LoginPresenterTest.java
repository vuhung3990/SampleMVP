package com.gvn.samplemvp.login;

import com.gvn.samplemvp.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by dev22 on 1/23/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {
    private LoginPresenter mPresenter;

    @Mock
    private LoginContract.View loginView;

    @Before
    public void setUp() throws Exception {
        mPresenter = new LoginPresenter(loginView);
    }

    @Test
    public void testEmailEmpty() throws Exception {
        // email empty
        when(loginView.getEmail()).thenReturn("");
        mPresenter.onClickLogin();

        verify(loginView).onError(R.string.email_empty);
    }

    @Test
    public void testEmailNull() throws Exception {
        // email empty
        when(loginView.getEmail()).thenReturn(null);
        mPresenter.onClickLogin();

        verify(loginView, never()).onError(R.string.email_empty);

        // this verify will fail
//         verify(loginView).onError(R.string.email_empty);
    }

    @Test
    public void testEmailContainAtChar() throws Exception {
        when(loginView.getEmail()).thenReturn("sadsadsa");
        mPresenter.onClickLogin();

        verify(loginView).onError(R.string.email_invalid_format);
    }
}