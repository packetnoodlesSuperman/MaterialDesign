package com.bob.eventbus.coroutine.sample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bob.eventbus.R;
import com.bob.eventbus.coroutine.EventBus;
import com.bob.eventbus.coroutine.EventBusKt;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        EventBus.INSTANCE.register(this.getClass().getSimpleName(), EventBusKt.getUI(),
                UserEvent.class, userEvent -> {
                    Log.e("EventBus", userEvent.name);
                    return null;
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.tvNavigationActivityB).setOnClickListener(v -> {
            startActivity(new Intent(ActivityA.this, ActivityB.class));
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
