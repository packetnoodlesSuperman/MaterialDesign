package com.bob.jetpack.lifecycle;

public interface GenericLifecycleObserver extends LifecycleObserver {

    void onStateChanged(LifecycleOwner source, Lifecycle.Event event);

}
