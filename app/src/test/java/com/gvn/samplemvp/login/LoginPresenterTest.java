package com.gvn.samplemvp.login;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by Meo on 12/29/2016.
 */
public class LoginPresenterTest {
    @Test
    public void StringUtils_testNull() throws Exception {
        assertFalse(LoginPresenter.isStringNotEmptyOrNull(null));
    }

    @Test
    public void StringUtils_testEmpty() throws Exception {
        assertFalse(LoginPresenter.isStringNotEmptyOrNull("        "));
    }

    @Test
    public void StringUtils_testEmpty2() throws Exception {
        assertFalse(LoginPresenter.isStringNotEmptyOrNull(""));
    }
}