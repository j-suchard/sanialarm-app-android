package de.cvd.gs.sanialarm.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import de.cvd.gs.sanialarm.ui.login.data.LoginFormState;
import de.cvd.gs.sanialarm.ui.login.data.LoginResult;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();


}
