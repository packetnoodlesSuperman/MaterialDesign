package com.bob.jetpack.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

public abstract class Lifecycle {

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver observer);

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver observer);

    @MainThread
    @NonNull
    public abstract State getCurrentState();


    public enum Event{

        /**
         * Constant for onCreate event of the LifecycleOwner
         */
        ON_CREATE,
        /**
         * Constant for onStart event of the LifecycleOwner
         */
        ON_START,
        /**
         * Constant for onResume event of the LifecycleOwner
         */
        ON_RESUME,
        /**
         * Constant for onPause event of the  LifecycleOwner
         */
        ON_PAUSE,
        /**
         * Constant for onStop event of the LifecycleOwner
         */
        ON_STOP,
        /**
         * Constant for onDestroy event of the  LifecycleOwner
         */
        ON_DESTROY,
        /**
         * An {@link Event Event} constant that can be used to match all events.
         * 一个Event可以用来匹配所有事件的常数
         */
        ON_ANY
    }

    public enum State {

        DESTROYED,

        INITIALIZED,

        CREATED,

        STARTED,

        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            //用于比较两个枚举类型对象定义是的顺序
            //在后面为1  比较自己为0  否则为-1
            return compareTo(state) >= 0;
        }

    }

}
