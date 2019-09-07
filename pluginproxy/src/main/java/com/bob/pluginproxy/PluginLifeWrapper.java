package com.bob.pluginproxy;

import android.app.Activity;
import android.os.Bundle;

public class PluginLifeWrapper extends Activity implements Pluginable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        onPluginCreate(savedInstanceState);
    }

    @Override
    public void onPluginCreate(Bundle bundle) {

    }

    @Override
    protected void onStart() {
        onPluginStart();
    }

    @Override
    public void onPluginStart() {

    }

    @Override
    protected void onResume() {
        onPluginResume();
    }

    @Override
    public void onPluginResume() {

    }

    @Override
    protected void onStop() {
        onPluginStop();
    }

    @Override
    public void onPluginStop() {

    }

    @Override
    protected void onPause() {
        onPluginPause();
    }

    @Override
    public void onPluginPause() {

    }

    @Override
    protected void onDestroy() {
        onPluginDestroy();
    }

    @Override
    public void onPluginDestroy() {

    }
}
