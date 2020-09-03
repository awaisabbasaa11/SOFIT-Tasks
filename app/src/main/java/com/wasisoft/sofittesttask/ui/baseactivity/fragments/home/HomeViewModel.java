package com.wasisoft.sofittesttask.ui.baseactivity.fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.wasisoft.sofittesttask.model.News;
import com.wasisoft.sofittesttask.model.PaymentHistory;
import com.wasisoft.sofittesttask.repository.HomeRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    public LiveData<List<News>> liveDataOfNews;
    public LiveData<List<PaymentHistory>> liveDataOfPaymentHistory;

    public HomeViewModel() {
        HomeRepository repository = HomeRepository.getRepository();
        liveDataOfNews = repository.getNews();
        liveDataOfPaymentHistory = repository.getPaymentHistory();
    }
}