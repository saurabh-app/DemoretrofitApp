package com.example.studyleagueapp.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.studyleagueapp.R;
import com.example.studyleagueapp.adapter.ProducttitleAdapter;
import com.example.studyleagueapp.adapter.StoreAdapter;
import com.example.studyleagueapp.model.MasterRquestmodels;
import com.example.studyleagueapp.model.Product;
import com.example.studyleagueapp.model.ResultArray;
import com.example.studyleagueapp.network.ApiClient;
import com.example.studyleagueapp.network.RetrofitClients;
import com.example.studyleagueapp.service.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class StoreFragment extends Fragment {

    private RecyclerView recyclerView,recyclerView1;
    private StoreAdapter adapter;
    private ProducttitleAdapter mAdapter;

    private List<ResultArray> lists;
    private List<Product> productList;
    private ApiInterface apiInterface;
    public StoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_store, container, false);
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        recyclerView1 = view.findViewById(R.id.recycler_view1);
        recyclerView = view.findViewById(R.id.recycler_view);



        OnfetchData();
        return view;

    }

    private void OnfetchData() {

        ProgressDialog progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        Call<MasterRquestmodels> call = apiInterface.getData();

        call.enqueue(new Callback<MasterRquestmodels>() {
            @Override
            public void onResponse(Call<MasterRquestmodels> call, Response<MasterRquestmodels> response) {
                if(response.isSuccessful()){
                    progressDoalog.dismiss();
                    MasterRquestmodels masterRquestmodels = response.body();
                    lists = masterRquestmodels.getResultArray();
                    for(int l=0; l<=lists.size(); l++) {

                        try {
                            productList= lists.get(l).getProducts();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                        mAdapter = new ProducttitleAdapter(getContext(), lists);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerView1.setLayoutManager(layoutManager);
                    recyclerView1.setAdapter(mAdapter);
                    adapter = new StoreAdapter(getContext(), productList);
                    RecyclerView.LayoutManager llayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(llayoutManager);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setAdapter(adapter);
//                    mAdapter.setProductList(lists);


                }
                else {
                    progressDoalog.show();
                    Toast.makeText(getContext(), "Error! Please try again!"+response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MasterRquestmodels> call, Throwable t) {
                progressDoalog.show();
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}