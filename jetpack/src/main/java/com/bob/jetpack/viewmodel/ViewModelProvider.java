package com.bob.jetpack.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class ViewModelProvider {

    private static final String DEFAULT_KEY = "android.arch.lifecycle.ViewModelProvider.DefaultKey";

    public interface Factory {

        <T extends ViewModel> T create(Class<T> modelClass);

    }

    private final Factory mFactory;

    private final ViewModelStore mViewModelStore;

    public ViewModelProvider(@NonNull ViewModelStoreOwner owner, @NonNull Factory factory) {
        this(owner.getViewModelStore(), factory);
    }

    public ViewModelProvider(@NonNull ViewModelStore store, @NonNull Factory factory) {
        mFactory = factory;
        this.mViewModelStore = store;
    }

}

