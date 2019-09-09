//package com.bob.framework.base;
//
//import android.app.Application;
//import android.content.Context;
//import androidx.annotation.NonNull;
//import androidx.lifecycle.AndroidViewModel;
//
//public abstract class BaseViewModel<T extends BaseRepository> extends AndroidViewModel {
//
//    protected Context context;
//
//    protected T repository;
//
//    public BaseViewModel(@NonNull Application application) {
//        super(application);
//        context = application;
//        repository = getRepository();
//    }
//
//    protected abstract T getRepository();
//}
