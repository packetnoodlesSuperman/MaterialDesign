package com.bob.jetpack.lifecycle;

import androidx.annotation.NonNull;

public class LifecycleRegistry extends Lifecycle {

    private State mState;

    @Override
    public void addObserver(@NonNull LifecycleObserver observer) {
        State initialState = mState == State.DESTROYED ? State.DESTROYED : State.INITIALIZED;

        ObserverWithState stateFulObserver = new ObserverWithState(observer, initialState);

    }

    @Override
    public void removeObserver(@NonNull LifecycleObserver observer) {

    }

    @NonNull
    @Override
    public State getCurrentState() {
        return null;
    }

    static class ObserverWithState {

        State mState;
        GenericLifecycleObserver mLifecycleObserver;

        ObserverWithState(LifecycleObserver observer, State initialState) {
//            mLifecycleObserver =
        }

    }
}
