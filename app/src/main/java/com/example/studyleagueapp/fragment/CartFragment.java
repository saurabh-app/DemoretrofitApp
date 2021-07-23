package com.example.studyleagueapp.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studyleagueapp.R;
import com.example.studyleagueapp.adapter.TasksAdapter;
import com.example.studyleagueapp.db.DatabaseClient;
import com.example.studyleagueapp.model.Productmodel;

import java.util.List;


public class CartFragment extends Fragment {


    private RecyclerView recyclerView;
    TasksAdapter adapter;
    public CartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_cart, container, false);
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        getTasks();
        return view;
    }

    private void getTasks() {

        class GetTasks extends AsyncTask<Void, Void, List<Productmodel>> {

            @Override
            protected List<Productmodel> doInBackground(Void... voids) {
                List<Productmodel> productmodelList = DatabaseClient
                        .getInstance(getActivity())
                        .getAppDatabase()
                        .productDao()
                        .getAll();
                return productmodelList;
            }

            @Override
            protected void onPostExecute(List<Productmodel> productmodels) {
                super.onPostExecute(productmodels);
                 adapter = new TasksAdapter(getContext(), productmodels);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }

}