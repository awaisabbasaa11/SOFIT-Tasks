package com.wasisoft.sofittesttask.ui.baseactivity.fragments.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.GovernmentServiceParent;

import java.util.List;


public class ServicesFragment extends Fragment {
    private ServiceViewModel servicesViewModel;
    private RecyclerView recyclerView;
    private Observer<List<GovernmentServiceParent>> serviceObserver = governmentServiceParents -> {
        if (governmentServiceParents != null)
            recyclerView.setAdapter(new ParentRecyclerAdapter(governmentServiceParents));
    };

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        requireActivity().setTitle(R.string.government_services);
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_nav_bar);
        if (bottomNavigationView != null) bottomNavigationView.setVisibility(View.GONE);

        servicesViewModel = new ViewModelProvider(this).get(ServiceViewModel.class);
        return inflater.inflate(R.layout.fragment_services, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.parent_recycler_view);
        recyclerView.setHasFixedSize(true);
        servicesViewModel.liveDataOfGovernmentServices.observe(getViewLifecycleOwner(), serviceObserver);
    }
}