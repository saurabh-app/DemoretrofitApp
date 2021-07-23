package com.example.studyleagueapp.service;

import com.example.studyleagueapp.model.MasterRquestmodels;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET(EndApi.PRODUCTLIST)
     Call<MasterRquestmodels> getData();
}
