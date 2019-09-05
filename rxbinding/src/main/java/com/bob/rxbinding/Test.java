package com.bob.rxbinding;

import com.bob.rxbinding.widget.RxTextView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Test {

    public void test() {
        RxTextView
                .editorActions(null)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
}

}
