package com.bob.rxbinding.widget;

import android.widget.TextView;
import com.bob.rxbinding.internal.Functions;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;


public final class RxTextView {

    public static Observable<Integer> editorActions(TextView view) {
        return editorActions(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<Integer> editorActions(TextView view, Predicate<? super Integer> handled) {
        return new TextViewEditorActionObservable(view, handled);
    }

}
