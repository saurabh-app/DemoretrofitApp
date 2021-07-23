package com.example.studyleagueapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studyleagueapp.R;
import com.example.studyleagueapp.model.Product;
import com.example.studyleagueapp.model.Productmodel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {
    Context context;
    List<Productmodel> productmodels;
    String name,desc,price,selling_price,discounts,img,Qty;
    String id;

    public TasksAdapter(Context context, List<Productmodel> productmodel) {
        this.context = context;
        this.productmodels = productmodel;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_recent_products, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        for (int l = 0; l <= productmodels.size(); l++) {
            Productmodel product = productmodels.get(position);
            id = String.valueOf(product.getId());
            name = product.getName();
            desc = product.getDiscount();
            price = String.valueOf(Float.valueOf(product.getActualPrice()));
            selling_price = String.valueOf(Float.valueOf(product.getFinalPrice()));
//            try {
//                discounts = String.valueOf(Float.valueOf(product.getDiscount()));
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }

//            Qty = String.valueOf(Float.valueOf(product.getQty()));

            holder.product_id.setText(id);

            holder.product_name.setText(name);
            holder.product_short_desc.setText(desc);
            holder.product_price.setText(price);
            holder.selling_price.setText(selling_price);
            holder.discount.setText(discounts + " %   OFF");
        }

    }

    @Override
    public int getItemCount() {
        return productmodels.size();
    }

    public class TasksViewHolder extends RecyclerView.ViewHolder {
        TextView product_id, product_name, product_short_desc, product_price, selling_price, brand_name, discount, product_add;

        ImageView product_img;
        LinearLayout product_card;


        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);


            product_id = itemView.findViewById(R.id.product_id);
            product_name = itemView.findViewById(R.id.product_name);
            product_short_desc = itemView.findViewById(R.id.product_short_desc);
            product_img = itemView.findViewById(R.id.product_img);
            product_price = itemView.findViewById(R.id.product_price);
            selling_price = itemView.findViewById(R.id.selling_price);
            brand_name = itemView.findViewById(R.id.brand_name);
            discount = itemView.findViewById(R.id.discount);
            product_add = itemView.findViewById(R.id.product_add);

            product_card = itemView.findViewById(R.id.product_card);
        }
    }
}