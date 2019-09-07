package com.bob.pluginhook.test;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bob.pluginhook.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
