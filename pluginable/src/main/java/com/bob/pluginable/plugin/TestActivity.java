package com.bob.pluginable.plugin;

import android.os.Bundle;
import android.widget.ImageView;
import com.bob.pluginable.R;
import com.bob.pluginproxy.PluginActivity;

public class TestActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("Plugin App");
        ((ImageView) findViewById(R.id.iv_logo)).setImageResource(R.drawable.android);
    }

}
