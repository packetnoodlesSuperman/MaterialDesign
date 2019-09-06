package com.bob.jetpack.viewmodel;


/**
 * ViewModel 的作用就是 UI控制器 https://juejin.im/post/5bfc9d40e51d450ad42ab3c8
 *
 * ViewModel的特点
 *      1. 更加方便的保存数据
 *      2. 保存数据不受Activity的销毁重建影响  只有Activity在finish后调用onDestroy才会销毁
 *
 * ViewModel的生命周期
 *      ViewModel会一直保留在内存中，直到Activity、Fragment以下情况才会销毁
 *      宿主Activity被finish后调用onDestroy方法
 *      宿主Fragment被detached后调用onDetach方法
 */
public class ViewModel extends androidx.lifecycle.ViewModel {

    /**
     * 被销毁时的回调
     */
    @Override
    protected void onCleared() {
        super.onCleared();
    }


}
