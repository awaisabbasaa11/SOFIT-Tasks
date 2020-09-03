package com.wasisoft.sofittesttask.ui.baseactivity.fragments.services;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.wasisoft.sofittesttask.model.GovernmentServiceParent;
import com.wasisoft.sofittesttask.repository.ServiceRepository;

import java.util.List;

public class ServiceViewModel extends ViewModel {
    public LiveData<List<GovernmentServiceParent>> liveDataOfGovernmentServices;

    public ServiceViewModel() {
        ServiceRepository repository = ServiceRepository.getRepository();
        liveDataOfGovernmentServices = repository.getGovernmentServiceList();
    }
}