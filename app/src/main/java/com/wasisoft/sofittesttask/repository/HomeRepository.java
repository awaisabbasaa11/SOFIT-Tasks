package com.wasisoft.sofittesttask.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.News;
import com.wasisoft.sofittesttask.model.PaymentHistory;
import com.wasisoft.sofittesttask.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class HomeRepository {
    /**
     * Mimicking the real behaviour of MVVM with Repository pattern
     **/
    private static HomeRepository repository;
    private List<News> listOfNews;
    private List<PaymentHistory> listOfPaymentHistory;

    private HomeRepository() {
        listOfNews = new ArrayList<>();
        listOfNews.add(new News(R.string.lorem_ipsum, Constants.IMG_URL_3));
        listOfNews.add(new News(R.string.lorem_ipsum, Constants.IMG_URL_2));
        listOfNews.add(new News(R.string.lorem_ipsum, Constants.IMG_URL_3));
        listOfNews.add(new News(R.string.lorem_ipsum, Constants.IMG_URL_2));

        listOfPaymentHistory = new ArrayList<>();
        listOfPaymentHistory.add(new PaymentHistory(R.string.payment_history, Constants.ICON_WALLET_URL));
        listOfPaymentHistory.add(new PaymentHistory(R.string.payment_history, Constants.ICON_WALLET_URL));
        listOfPaymentHistory.add(new PaymentHistory(R.string.payment_history, Constants.ICON_WALLET_URL));
        listOfPaymentHistory.add(new PaymentHistory(R.string.payment_history, Constants.ICON_WALLET_URL));
    }

    public static HomeRepository getRepository() {
        if (repository == null) repository = new HomeRepository();
        return repository;
    }

    public LiveData<List<News>> getNews() {
        MutableLiveData<List<News>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(listOfNews);
        return mutableLiveData;
    }

    public LiveData<List<PaymentHistory>> getPaymentHistory() {
        MutableLiveData<List<PaymentHistory>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(listOfPaymentHistory);
        return mutableLiveData;
    }
}
