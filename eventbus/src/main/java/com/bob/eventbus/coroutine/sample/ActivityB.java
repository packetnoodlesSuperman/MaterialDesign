package com.bob.eventbus.coroutine.sample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bob.eventbus.R;
import com.bob.eventbus.coroutine.EventBus;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        EventBus.post(
                new UserEvent("XHB_XHB"), 0L
        );
    }
}
