package com.bob.jetpack.livedata;

import android.annotation.SuppressLint;
import androidx.arch.core.internal.SafeIterableMap;

public abstract class LiveData<T> {

    @SuppressWarnings("WeakerAccess")
    final Object mDataLock = new Object();
    static final int START_VERSION = -1;
    @SuppressWarnings("WeakerAccess")
    static final Object NOT_SET = new Object();

    volatile Object mPendingData = NOT_SET;

    @SuppressLint("RestrictedApi")
    private SafeIterableMap<Observer<? super T>, ObserverWrapper> mObservers =
            new SafeIterableMap<>();

    @SuppressWarnings("WeakerAccess")
    int mActiveCount = 0;

    private volatile Object mData = NOT_SET;
    private int mVersion = START_VERSION;

    private final Runnable mPostValueRunnable = new Runnable() {
        @Override
        public void run() {
            Object newValue;
            synchronized (mDataLock) {
                newValue = mPendingData;
                mPendingData = NOT_SET;
            }

            setValue((T) newValue);
        }
    };

    protected void postValue(T value) {
        boolean postTask;
        synchronized (mDataLock) {
            postTask = mPendingData == NOT_SET;
            mPendingData = value;
        }
    }

    protected void setValue(T value) {
        mVersion++;
        mData = value;
//        dispatchingValue(null);
    }

    private abstract class ObserverWrapper {
        final Observer<? super T> mObserver;
        boolean mActive;
        int mLastVersion = START_VERSION;

        ObserverWrapper(Observer<? super T> observer) {
            mObserver = observer;
        }

        abstract boolean shouldBeActive();
    }

}