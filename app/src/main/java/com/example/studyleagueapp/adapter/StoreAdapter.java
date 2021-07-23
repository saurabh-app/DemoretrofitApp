package com.example.studyleagueapp.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyleagueapp.R;
import com.example.studyleagueapp.db.DatabaseClient;
import com.example.studyleagueapp.model.Image;
import com.example.studyleagueapp.model.Product;
import com.example.studyleagueapp.model.Productmodel;
import com.example.studyleagueapp.model.ResultArray;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ProductsViewHolder>{

    Context mcontext;
    List<Product> productList;
    List<Image> image;
   private String name,desc,price,selling_price,discounts,img,Qty;
  private   String id;
    public StoreAdapter(Context context, List<Product> productList) {
        this.mcontext=context;
        this.productList= productList;
    }


    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_recent_products, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        for (int l = 0; l <= productList.size(); l++) {
            Product product = productList.get(position);
             image=productList.get(position).getImages();
            for(int i=0; i<=image.size(); i++) {

                try {
                    img = String.valueOf(image.get(i).getImgProduct());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            id = String.valueOf(product.getId());
            name = product.getName();
            desc = product.getDiscount();
            price = String.valueOf(Float.valueOf(product.getActualPrice()));
            selling_price = String.valueOf(Float.valueOf(product.getFinalPrice()));
            discounts = String.valueOf(Float.valueOf(product.getDiscount()));
            Qty = String.valueOf(Float.valueOf(product.getQty()));

            holder.product_id.setText(id);

            holder.product_name.setText(name);
            holder.product_short_desc.setText(desc);
            holder.product_price.setText(price);
            holder.selling_price.setText(selling_price);
            holder.discount.setText(discounts + " %   OFF");
//            holder.product_add.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    InsertProduct();
//                    return false;
//                }
//            });
                    holder.product_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
               InsertProduct();
                }
            });


            Picasso.get().load(img)
                    .placeholder(R.drawable.home)
                    .into(holder.product_img);
        }
    }

    private void InsertProduct() {

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task

                Productmodel productmodel = new Productmodel();
                productmodel.setName(name);
                productmodel.setActualPrice(selling_price);
//            productmodel.setCategoryName(sDesc);
            productmodel.setDiscount(discounts);
                productmodel.setFinalPrice(price);
                productmodel.setId(Integer.parseInt(id));
                productmodel.setImages(String.valueOf(image));
//            productmodel.setQty();


                //adding to database
                try {
                    DatabaseClient.getInstance(mcontext).getAppDatabase()
                            .productDao()
                            .insert(productmodel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
//            this.finish();
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(mcontext, "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView product_id,product_name,product_short_desc,product_price,selling_price,brand_name,discount,product_add;

        ImageView product_img;
        LinearLayout product_card;
        public ProductsViewHolder(@NonNull View itemView) {
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
