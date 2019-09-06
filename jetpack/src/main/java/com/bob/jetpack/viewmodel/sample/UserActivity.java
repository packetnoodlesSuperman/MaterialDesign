package com.bob.jetpack.viewmodel.sample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * ViewModelProvides 出自于 android.arch.lifecycle:extensions 扩展库
         */
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }
}
