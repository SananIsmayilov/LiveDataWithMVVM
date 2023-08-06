package com.sananismayilov.livedata.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<String> stringMutableLiveData1 = new MutableLiveData<>("null");

    public MutableLiveData<String> getStringMutableLiveData() {
        return stringMutableLiveData1;
    }

    public void setStringMutableLiveData(String stringMutableLiveData) {
        stringMutableLiveData1.setValue(stringMutableLiveData);
    }
}
