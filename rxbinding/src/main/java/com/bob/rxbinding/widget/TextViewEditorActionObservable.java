package com.bob.rxbinding.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/**
 * 被观察者
 */
public class TextViewEditorActionObservable extends Observable<Integer> {

    private final TextView view;
    private final Predicate<? super Integer> handled;

    public TextViewEditorActionObservable(TextView view, Predicate<? super Integer> handled) {
        this.view = view;
        this.handled = handled;
    }

    @Override
    protected void subscribeActual(Observer<? super Integer> observer) {
        Listener listener = new Listener(view, observer, handled);
        observer.onSubscribe(listener);
        view.setOnEditorActionListener(listener);
    }

    /**
     * MainThreadDisposable implements Disposable
     *
     */
    static final class Listener extends MainThreadDisposable implements TextView.OnEditorActionListener {

        private final TextView view;
        private final Observer<? super Integer> observer;
        private final Predicate<? super Integer> handled;

        Listener(TextView view, Observer<? super Integer> observer, Predicate<? super Integer> handled) {
            this.view = view;
            this.observer = observer;
            this.handled = handled;
        }

        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

            try {
                if (!isDisposed() && handled.test(actionId)) {
                    observer.onNext(actionId);
                    return true;
                }
            } catch (Exception e) {
                observer.onError(e);
                dispose();
            }
            return false;
        }


        /**
         * 调用dispose() 方法的时候 调用该方法
         */
        @Override
        protected void onDispose() {
            view.setOnEditorActionListener(null);
        }
    }
}
