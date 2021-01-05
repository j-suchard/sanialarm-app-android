package de.cvd.gs.sanialarm.ui.login.data;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.cvd.gs.sanialarm.AccountType;
import de.cvd.gs.sanialarm.MainActivity;
import de.cvd.gs.sanialarm.User;

public class LoginSource {

    LoginResult result;

    public LoginResult<User> login(String email_address, String password) {
        RequestQueue queue = MainActivity.applicationViewModel.getVolleyRequestQueue();
        JSONObject postData = new JSONObject();
        JSONObject loginData = new JSONObject();
        try {
            // Create JSON Object to post to the server
            loginData.put("emailAddress", email_address);
            loginData.put("password", password);
            postData.put("action", "login:mobile");
            postData.put("loginData", loginData);
        } catch (Exception e) {
            result = new LoginResult.Error(e);
        }
        // Create url string for the server connection
        String url = "https://sanidienst-cvd.spdns.de/apiv2";
        JsonObjectRequest loginRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getBoolean("validData")) {
                        List<AccountType> accountTypes = new ArrayList<>();
                        if (response.getJSONObject("accountData").getBoolean("adminAccount"))
                            accountTypes.add(AccountType.ADMIN);
                        if (response.getJSONObject("accountData").getBoolean("responderAccount"))
                            accountTypes.add(AccountType.RESPONDER);
                        if (response.getJSONObject("accountData").getBoolean("adminAccount"))
                            accountTypes.add(AccountType.DEVELOPER);
                        User user = new User(
                            response.getJSONObject("accountData").getInt("internalID"),
                            response.getJSONObject("accountData").getString("accountID"),
                            response.getJSONObject("accountData").getString("givenName"),
                            response.getJSONObject("accountData").getString("surname"),
                            response.getJSONObject("accountData").getString("email_address"),
                            accountTypes
                        );
                        result = new LoginResult.Success(user);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, Throwable::printStackTrace) {
            @Override
            public byte[] getBody() {
                return postData.toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add(loginRequest);
        return result;
    }

}
