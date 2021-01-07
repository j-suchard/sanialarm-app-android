package de.cvd.gs.sanialarm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.RequestQueue;

public class ApplicationViewModel extends ViewModel {
    private RequestQueue volleyRequestQueue;
    private MutableLiveData<Boolean> loginTried = new MutableLiveData<>();

    public RequestQueue getVolleyRequestQueue() {
        return volleyRequestQueue;
    }

    public void setVolleyRequestQueue(RequestQueue queue) {
        this.volleyRequestQueue = queue;
    }

    public MutableLiveData<Boolean> getLoginTried() {
        return loginTried;
    }

    public void setLoginTried(MutableLiveData<Boolean> loginTried) {
        this.loginTried = loginTried;
    }
}
