package com.wasisoft.sofittesttask.ui.baseactivity.fragments.home;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.News;
import com.wasisoft.sofittesttask.model.PaymentHistory;
import com.wasisoft.sofittesttask.ui.baseactivity.fragments.services.ServicesFragment;
import com.wasisoft.sofittesttask.util.Constants;

import java.util.List;


public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private RecyclerView newsRecyclerView;
    private RecyclerView paymentHistoryRecyclerView;
    private Observer<List<News>> newsObserver = news -> {
        if (news != null) newsRecyclerView.setAdapter(new HeaderRecyclerAdapter(news));
    };
    private Observer<List<PaymentHistory>> paymentHistoryObserver = paymentHistories -> {
        if (paymentHistories != null)
            paymentHistoryRecyclerView.setAdapter(new PaymentHistoryRecyclerAdapter(paymentHistories));
    };

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_nav_bar);
        if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.VISIBLE);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsRecyclerView = view.findViewById(R.id.recycler_view);
        paymentHistoryRecyclerView = view.findViewById(R.id.recycler_view_of_payment);
        newsRecyclerView.setHasFixedSize(true);
        paymentHistoryRecyclerView.setHasFixedSize(true);
        homeViewModel.liveDataOfNews.observe(getViewLifecycleOwner(), newsObserver);
        homeViewModel.liveDataOfPaymentHistory.observe(getViewLifecycleOwner(), paymentHistoryObserver);
        TextView otherService1 = (TextView) view.findViewById(R.id.other_services_1);
        TextView otherService2 = (TextView) view.findViewById(R.id.other_services_2);
        TextView otherService3 = (TextView) view.findViewById(R.id.other_services_3);
        TextView otherService4 = (TextView) view.findViewById(R.id.other_services_4);
        TextView govService1 = (TextView) view.findViewById(R.id.govt_services_1);
        TextView govService2 = (TextView) view.findViewById(R.id.govt_services_2);
        TextView govService3 = (TextView) view.findViewById(R.id.govt_services_3);
        TextView govService4 = (TextView) view.findViewById(R.id.govt_services_4);

        populateServiceViews(govService1, getString(R.string.working_with_government), Constants.ICON_TOWN_URL);
        populateServiceViews(govService2, getString(R.string.here_there_visiting), Constants.ICON_PIN_URL);
        populateServiceViews(govService3, getString(R.string.house_buy_rent), Constants.ICON_HOME_URL);
        populateServiceViews(govService4, getString(R.string.shopings_sellings), Constants.ICON_WALLET_URL);
        populateServiceViews(otherService1, getString(R.string.home_services), Constants.ICON_HOME_URL);
        populateServiceViews(otherService2, getString(R.string.construction), Constants.ICON_SHOVEL_URL);
        populateServiceViews(otherService3, getString(R.string.online_earning), Constants.ICON_LAW_URL);
        populateServiceViews(otherService4, getString(R.string.consultation), Constants.ICON_SELLER_URL);

        ImageView imageView = view.findViewById(R.id.service_button);
        imageView.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction()
                    .replace(((ViewGroup) getView().getParent()).getId(), new ServicesFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }

    void populateServiceViews(TextView view, String text, String imgUrl) {
        view.setText(text);
        Glide
                .with(requireContext())
                .asBitmap()
                .load(imgUrl)
                .placeholder(R.drawable.ic_placeholder)
                .centerInside()
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        view.setCompoundDrawablesWithIntrinsicBounds(null, new BitmapDrawable(getResources(), resource), null, null);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });
    }

}