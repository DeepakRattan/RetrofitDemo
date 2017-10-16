package com.example.deepakrattan.retrofitdemo.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.deepakrattan.retrofitdemo.R;
import com.example.deepakrattan.retrofitdemo.model.LoginData;
import com.example.deepakrattan.retrofitdemo.model.LoginResponse;
import com.example.deepakrattan.retrofitdemo.network.ApiCient;
import com.example.deepakrattan.retrofitdemo.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRequestActivity extends AppCompatActivity {
    private EditText edtName, edtPassword;
    private Button btnLogin;
    private ApiInterface apiInterface;
    public static final String TAG = "login";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Please wait...");
                String email = edtName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                apiInterface = ApiCient.getRetrofitInstance().create(ApiInterface.class);
                Call<LoginResponse> call = apiInterface.getLogin(new LoginData(email, password));
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        progressDialog.dismiss();
                        LoginResponse loginResponse = response.body();
                        String name = loginResponse.getFName();
                        Toast.makeText(PostRequestActivity.this, "name is " + name, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        progressDialog.dismiss();
                        Log.d(TAG, "onFailure: " + t.getMessage());

                    }
                });


            }
        });

    }
}
