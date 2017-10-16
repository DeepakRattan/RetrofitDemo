package com.example.deepakrattan.retrofitdemo.network;

import com.example.deepakrattan.retrofitdemo.model.EmployeeList;
import com.example.deepakrattan.retrofitdemo.model.LoginData;
import com.example.deepakrattan.retrofitdemo.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by deepak.rattan on 10/16/2017.
 */

public interface ApiInterface {
    @GET("retrofit-demo.php")
    Call<EmployeeList> getEmployee(@Query("company_no") int companyNo);

    @POST("AccountAPI/GetLoginUser")
    Call<LoginResponse> getLogin(@Body LoginData body);


}
