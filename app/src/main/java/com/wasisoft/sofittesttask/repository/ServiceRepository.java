package com.wasisoft.sofittesttask.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wasisoft.sofittesttask.R;
import com.wasisoft.sofittesttask.model.GovernmentServiceChild;
import com.wasisoft.sofittesttask.model.GovernmentServiceParent;
import com.wasisoft.sofittesttask.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    /**
     * Mimicking the real behaviour of MVVM with Repository pattern
     **/
    private static ServiceRepository repository;
    private List<GovernmentServiceParent> listOfParent;

    private ServiceRepository() {
        listOfParent = new ArrayList<>();
        listOfParent.add(new GovernmentServiceParent(createDummyChildList()));
        listOfParent.add(new GovernmentServiceParent(createDummyChildList()));
        listOfParent.add(new GovernmentServiceParent(createDummyChildList()));
        listOfParent.add(new GovernmentServiceParent(createDummyChildList()));
    }

    public static ServiceRepository getRepository() {
        if (repository == null) repository = new ServiceRepository();
        return repository;
    }

    public LiveData<List<GovernmentServiceParent>> getGovernmentServiceList() {
        MutableLiveData<List<GovernmentServiceParent>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(listOfParent);
        return mutableLiveData;
    }

    private List<GovernmentServiceChild> createDummyChildList() {
        List<GovernmentServiceChild> childList = new ArrayList<>();
        childList.add(new GovernmentServiceChild(R.string.working_with_government, Constants.ICON_TOWN_URL));
        childList.add(new GovernmentServiceChild(R.string.construction, Constants.ICON_SHOVEL_URL));
        childList.add(new GovernmentServiceChild(R.string.house_buy_rent, Constants.ICON_HOME_URL));
        childList.add(new GovernmentServiceChild(R.string.online_earning, Constants.ICON_WALLET_URL));
        childList.add(new GovernmentServiceChild(R.string.home_services, Constants.ICON_TOWN_URL));
        childList.add(new GovernmentServiceChild(R.string.consultation, Constants.ICON_SELLER_URL));
        childList.add(new GovernmentServiceChild(R.string.here_there_visiting, Constants.ICON_PIN_URL));
        childList.add(new GovernmentServiceChild(R.string.shopings_sellings, Constants.ICON_LAW_URL));
        childList.add(new GovernmentServiceChild(R.string.consultation, Constants.ICON_SELLER_URL));
        childList.add(new GovernmentServiceChild(R.string.online_earning, Constants.ICON_WALLET_URL));
        return childList;
    }
}
