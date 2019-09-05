package com.bob.rxbinding.widget;

import android.widget.TextView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;

public class TextViewEditorActionObservable extends Observable<Integer> {


    public TextViewEditorActionObservable(TextView view, Predicate<? super Integer> handled) {

    }

    @Override
    protected void subscribeActual(Observer<? super Integer> observer) {
//        observer.onSubscribe();
//        view.setOn
    }
}
