package com.bob.jetpack.viewmodel;

import android.app.Application;
import androidx.lifecycle.ViewModel;

public class AndroidViewModel extends ViewModel {

    private Application mApplication;

    public AndroidViewModel(Application application) {
        mApplication = application;
    }

    public <T extends Application> T getApplication() {
        return (T) mApplication;
    }

}
