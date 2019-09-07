package com.bob.pluginproxy;

import android.app.Activity;
import android.os.Bundle;

public class ProxyActivity extends Activity {

    ProxyActivityImpl mProxyActivityImpl = new ProxyActivityImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProxyActivityImpl.onPluginCreate(getIntent().getExtras());
    }
}
