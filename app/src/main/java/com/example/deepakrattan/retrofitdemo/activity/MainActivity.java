package com.example.deepakrattan.retrofitdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.deepakrattan.retrofitdemo.R;
import com.example.deepakrattan.retrofitdemo.adapter.EmployeeAdapter;
import com.example.deepakrattan.retrofitdemo.model.Employee;
import com.example.deepakrattan.retrofitdemo.model.EmployeeList;
import com.example.deepakrattan.retrofitdemo.network.ApiCient;
import com.example.deepakrattan.retrofitdemo.network.*;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //We are interested in hitting the following API
    // http://navjacinth9.000webhostapp.com/json/retrofit-demo.php?company_no=123
    private ApiInterface apiInterface;
    private ArrayList<Employee> employeeArrayList;
    private StringBuffer stringBuffer;
    public static final String TAG = "Response";
    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private EmployeeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        apiInterface = ApiCient.getRetrofitInstance().create(ApiInterface.class);
        Call<EmployeeList> call = apiInterface.getEmployee(100);
        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                EmployeeList employeeList = response.body();
                employeeArrayList = employeeList.getEmployeeList();
                adapter = new EmployeeAdapter(MainActivity.this, employeeArrayList);
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });

    }

   /* public String getEmployee(ArrayList<Employee> employeeArrayList) {
        stringBuffer = new StringBuffer(" ");

        for (int i = 0; i < employeeArrayList.size(); i++) {
            String name = employeeArrayList.get(i).getName();
            stringBuffer.append(name + " ");
        }
        return stringBuffer.toString();

    }*/
}
