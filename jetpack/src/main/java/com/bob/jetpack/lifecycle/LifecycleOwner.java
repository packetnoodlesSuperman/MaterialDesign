package com.bob.jetpack.lifecycle;

/**
 * 生命周期的事件分发者，
 * 在 Activity/Fragment 他们的生命周期发生变化的时发出相应的 Event 给 LifecycleRegistry
 */
public interface LifecycleOwner {

    Lifecycle getLifecycle();

}
