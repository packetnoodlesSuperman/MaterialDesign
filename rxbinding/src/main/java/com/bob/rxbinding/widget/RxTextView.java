package com.bob.rxbinding.widget;

import android.widget.TextView;
import com.bob.rxbinding.internal.Functions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;


public final class RxTextView {

    public static Observable<Integer> editorActions(TextView view) {
        return editorActions(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    public static Observable<Integer> editorActions(TextView view, Predicate<? super Integer> handled) {
        return new TextViewEditorActionObservable(view, handled);
    }


    @Deprecated
    public static Consumer<? super CharSequence> text(TextView view) {
//        方式一
//        return new Consumer<CharSequence>() {
//            @Override
//            public void accept(CharSequence charSequence) throws Exception {
//                view.setText(charSequence);
//            }
//        };
//        方式二
//        return (Consumer<CharSequence>) charSequence -> view.setText(charSequence);

//        方式三 java8  jdk8中使用了::的用法。就是把方法当做参数传到stream内部
        return view::setText;
    }

}
