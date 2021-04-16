package com.example.apecsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VerificationActivity extends AppCompatActivity {
    private static final String TAG = RegistrationActivity.class.getSimpleName();
    ProfilesDataSQLHelper profilesData;
    EditText email;
    EditText password;
    ProgressDialog pDialog;
    Button loginButton;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        profilesData = new ProfilesDataSQLHelper(this);

        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            Intent intent = new Intent(VerificationActivity.this, StartOption.class);
            startActivity(intent);
            finish();
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                if (!Email.isEmpty() && !Password.isEmpty()) {
                    checkLogin(Email, Password);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }

            }
        });
    }


    private void checkLogin(final String email, final String password) {
        String tag_string_req = "req_login";
        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response);
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");


                    if (!error) {

                        session.setLogin(true);
                        //JSONObject user = jObj.getJSONObject("user");
                        //String name = user.getString("name");
                        //String age = user.getString("age");
                        //String diagnosis = user.getString("diagnosis");
                       // String email = user.getString("email");
                        //String password = user.getString("password");
                        //profilesData.addUser(name, age, diagnosis, email, password);
                        Intent intent = new Intent(VerificationActivity.this, StartOption.class);
                        startActivity(intent);
                        finish();
                    } else {
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }

        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    public void showDialog()

    {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    public void hideDialog () {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}