package com.example.studyleagueapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.studyleagueapp.R;
import com.example.studyleagueapp.model.ResultArray;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProducttitleAdapter extends RecyclerView.Adapter<ProducttitleAdapter.ProductViewHolder> {
    Context mcontext;
    List<ResultArray> lists;
    public ProducttitleAdapter(Context context, List<ResultArray> lists) {
        this.mcontext=context;
        this.lists=lists;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.products_list, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        for(int l=0; l<=lists.size(); l++){
            ResultArray resultArray=lists.get(position);

            try {
                holder.productname.setText(resultArray.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productname;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productname = itemView.findViewById(R.id.productname);
        }
    }
}
