package de.cvd.gs.sanialarm.ui.data;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import de.cvd.gs.sanialarm.MainActivity;
import de.cvd.gs.sanialarm.User;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    protected User user = null;


    public Result<User> login(String username, String password) throws JSONException {
        Result result;
        // Get main request queue
        RequestQueue queue = MainActivity.applicationViewModel.getVolleyRequestQueue();
        // URL for api access
        String url = "http://sanidienst-cvd.spdns.de:8889/";
        JSONObject postData = new JSONObject();
        JSONObject loginData = new JSONObject();
        loginData.put("emailAddress", username);
        loginData.put("password", password);
        postData.put("action", "login:mobile");
        postData.put("loginData", loginData);
        JsonObjectRequest loginRequest = new JsonObjectRequest(Request.Method.POST, url, postData, response -> {
            try {
                if (response.getBoolean("validData")) {
                    
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, Throwable::printStackTrace);
        queue.add(loginRequest);
    }

    public void logout() {
        // TODO: revoke authentication
    }

    private void tryPopulateProtectedUser(String email_address, String password) throws Exception{

    }
}