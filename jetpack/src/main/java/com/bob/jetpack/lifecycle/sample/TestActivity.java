package com.bob.jetpack.lifecycle.sample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bob.jetpack.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        /**
         * AppCompatActivity --> FragmentActivity --> ComponentActivity --> Activity
         * ComponentActivity --> getLifecycle() --> mLifecycleRegistry = new LifecycleRegistry(this)
         *              LifecycleRegistry 构造LifecycleOwner --> ComponentActivity implements LifecycleOwner
         *  重点研究 LifecycleRegistry的 addObserver(LifecycleObserver observer)  --> 如我们的TestPresenter implements LifecycleObserver
         */
        getLifecycle().addObserver(new TestPresenter());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
