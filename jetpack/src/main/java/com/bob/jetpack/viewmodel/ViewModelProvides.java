package com.bob.jetpack.viewmodel;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;


public class ViewModelProvides {

    private static Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            //抛出异常
        }
        return application;
    }

    private static Activity checkActivity(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
        }
        return activity;
    }

    public static ViewModelProvider of(Fragment fragment) {
        return of(fragment, null);
    }

    public static ViewModelProvider of(Fragment fragment, ViewModelProvider.Factory factory) {
        Application application = checkApplication(checkActivity(fragment));
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    public static ViewModelProvider of(FragmentActivity activity, ViewModelProvider.Factory factory) {
        Application application = checkApplication(activity);
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return new ViewModelProvider(activity.getViewModelStore(), factory);
    }

    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {

        public DefaultFactory(@NonNull Application application) {
            super(application);
        }
    }
}
