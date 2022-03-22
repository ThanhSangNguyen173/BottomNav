package com.example.bottomnav;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private List<Product> mListProduct;
    private IClickAddtoCartListener iClickAddtoCartListener;

    public interface IClickAddtoCartListener{
        void onClickAddtoCart(ImageView imgAddtoCart,Product product);
    }

    public void setData(List<Product> list, IClickAddtoCartListener listener){
        this.mListProduct = list;
        this.iClickAddtoCartListener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        Product product = mListProduct.get(position);
        if(product==null){
            return;
        }
        holder.imgProduct.setImageResource(product.getResourceId());
        holder.tvProductName.setText(product.getName());
        holder.tvDescription.setText(product.getDescription());

        holder.imgAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickAddtoCartListener.onClickAddtoCart(holder.imgAddtoCart,product);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListProduct!=null){
            return mListProduct.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgProduct;
        private TextView tvProductName;
        private TextView tvDescription;
        private ImageView imgAddtoCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            imgAddtoCart = itemView.findViewById(R.id.add_to_cart);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }

}
