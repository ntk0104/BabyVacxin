package com.dmt.sannguyen.lgwfb;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    ProfilePictureView profilePictureView;
    LoginButton loginButton;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.login);
        anhXa();
        loginButton.setReadPermissions(Arrays.asList("public_profile","email"));
        setLogin_button();

    }

    // Sign in function
    private void setLogin_button() {
        try {
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    String accesstoken = loginResult.getAccessToken().getToken();
                    GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            Log.d("Track", object.toString());
                            try {
                                //Send data to another acitivity
                                Bundle bundle = new Bundle();
                                bundle.putString("userid", object.getString("id").toString());
                                // Call API to check userid existed or not
                                checkExistedUser(object.getString("id").toString());

                                //send bundle data to BeYeuActivity activity
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
//                            try {
//                                txtemail.setText(object.getString("email"));
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
                        }
                    });

                    Bundle parameter = new Bundle();
                    //determine which userdata we will get
                    //Currently we get name, email and first_name of user
                    parameter.putString("fields","name, email, first_name");
                    graphRequest.setParameters(parameter);
                    graphRequest.executeAsync();
                }

                @Override
                public void onCancel() {
                    Log.d("Track", "onCancel");
                }

                @Override
                public void onError(FacebookException error) {
                    Log.d("Track", error.toString());

                }
            });
        }catch (Exception e){
            Log.d("Track", e.toString());
        }

    }

    private void checkExistedUser(final String userid){
        String url = "https://babyvacxin.azurewebsites.net/api/CheckUserExisted?code=1rM/4T2O/pALgGTBgnVQCDgFgLz1Dhz10ODeHFROkUjGHf3J401Nlw==";
        Log.d("Track", "Checking User Existed");
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Track", "Response from checkExistedUser :" + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Track", "Response from checkExistedUser :"+error);
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("username", userid);
                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }


    private void anhXa() {
        profilePictureView = findViewById(R.id.imageprofilepickture);
        loginButton = findViewById(R.id.login_button);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
