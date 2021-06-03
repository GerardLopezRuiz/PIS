package com.example.pis;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel implements DataBaseAdapter.vmInterface {
    private final MutableLiveData<ArrayList<nota>> mnota;
    private final MutableLiveData<String> mToast;


    public static final String TAG = "ViewModel";

    public MainActivityViewModel() {
        mnota= new MutableLiveData<>();
        mToast = new MutableLiveData<>();
        DataBaseAdapter da= new DataBaseAdapter(this);
        da.getCollection();
    }
    public LiveData<ArrayList<nota>> getNotaCards(){ return mnota; }

    public nota getNotaCard(int idx){ return mnota.getValue().get(idx); }

    public void addNotaCard(nota nota){
        mnota.getValue().add(nota);
        // Inform observer.
        mnota.setValue(mnota.getValue());
        nota.saveCard();
    }
    public LiveData<String> getToast(){
        return mToast;
    }

    @Override
    public void setCollection(ArrayList<nota> ac) { mnota.setValue(ac);}

    @Override
    public void setToast(String s) { mToast.setValue(TAG);}
}
