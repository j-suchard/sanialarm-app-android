package de.cvd.gs.sanialarm;

import androidx.lifecycle.ViewModel;

import com.android.volley.RequestQueue;

public class ApplicationViewModel extends ViewModel {
    private RequestQueue volleyRequestQueue;

    public RequestQueue getVolleyRequestQueue() {
        return volleyRequestQueue;
    }

    public void setVolleyRequestQueue(RequestQueue queue) {
        this.volleyRequestQueue = queue;
    }
}
