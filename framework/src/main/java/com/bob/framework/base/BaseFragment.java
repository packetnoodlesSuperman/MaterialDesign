//package com.bob.framework.base;
//
//import android.content.Context;
//import androidx.fragment.app.Fragment;
//
//public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {
//
//    protected T viewModel;
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (viewModel == null) {
//            viewModel = getViewModel();
//        }
//    }
//
//    protected abstract T getViewModel();
//}
