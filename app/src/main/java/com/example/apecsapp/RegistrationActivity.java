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
import com.example.apecsapp.AppController;
import com.example.apecsapp.ProfilesDataSQLHelper;
import com.example.apecsapp.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = RegistrationActivity.class.getSimpleName();
    ProfilesDataSQLHelper profilesData;
    EditText name;
    EditText age;
    EditText diagnosis;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button registerButton;
    ProgressDialog pDialog;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        registerButton = findViewById(R.id.button2);
        name = findViewById(R.id.editTextTextPersonName);
        age = findViewById(R.id.editTextNumber);
        diagnosis = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextEmailAddress2);
        password = findViewById(R.id.editTextTextPassword2);
        confirmPassword = findViewById(R.id.editTextTextPassword3);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        profilesData = new ProfilesDataSQLHelper(getApplicationContext());
        session = new SessionManager(getApplicationContext());

        if (session.isLoggedIn()) {
            Intent intent = new Intent(RegistrationActivity.this,
                    StartOption.class);
            startActivity(intent);
            finish();
        }
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String Name = name.getText().toString().trim();
                String Age = age.getText().toString().trim();
                String Diagnosis = diagnosis.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                String ConfirmPassword = confirmPassword.getText().toString().trim();
                if (!Name.isEmpty() && !Age.isEmpty() && !Diagnosis.isEmpty() && !Email.isEmpty() && !Password.isEmpty() && !ConfirmPassword.isEmpty()) {
                    if (Password.equals(ConfirmPassword)) {
                        registerUser(Name, Age, Diagnosis, Email, Password);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Passwords do not match!", Toast.LENGTH_LONG)
                                .show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    private void registerUser(final String Name, final String Age, final String Diagnosis, final String Email, final String Password){
        String tag_string_req = "req_register";
        pDialog.setMessage("Registering ...");
        showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>() {
            public void onResponse(String response) {
                Log.d(TAG,"Registration Response: " + response);
                hideDialog();
                try{
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        JSONObject user = jObj.getJSONObject("user");
                        String name1 = user.getString("name");
                        String age1 = user.getString( "age");
                        String diagnosis1 =user.getString("diagnosis");
                        String email1 = user.getString("email");
                        String password1 = user.getString("password");
                        profilesData.addUser(name1, age1, diagnosis1, email1, password1);
                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(
                                RegistrationActivity.this,
                                VerificationActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();}
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("name", Name);
                params.put("age",Age);
                params.put("diagnosis",Diagnosis);
                params.put("email", Email);
                params.put("password", Password);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }
    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}






