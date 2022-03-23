package com.example.bottomnav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Cart_fragment extends Fragment {
    private RecyclerView rcvProduct;
    private View mView;
    private BottomNav bottomNav;
    private ProductAdapter productAdapter;

    public Cart_fragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.product_fragment,container,false);
        bottomNav = (BottomNav) getActivity();
        rcvProduct = mView.findViewById(R.id.rcv_product);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(bottomNav);
        rcvProduct.setLayoutManager(linearLayoutManager);
        productAdapter = new ProductAdapter();
        productAdapter.setData(getListProduct(), new ProductAdapter.IClickAddtoCartListener() {
            @Override
            public void onClickAddtoCart(ImageView imgAddtoCart, Product product) {
                AnimationUtil.translateAnimation(bottomNav.getViewAnimation(), imgAddtoCart, bottomNav.getViewEndAnimation(), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
        rcvProduct.setAdapter(productAdapter);

        return mView;
    }

    private List<Product> getListProduct() {
        List<Product> list = new ArrayList<>();

        return list;
    }
}
