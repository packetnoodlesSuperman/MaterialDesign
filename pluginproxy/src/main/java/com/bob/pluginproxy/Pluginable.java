package com.bob.pluginproxy;

import android.os.Bundle;

public interface Pluginable {

    public void onPluginCreate(Bundle bundle);

    public void onPluginStart();

    public void onPluginResume();

    public void onPluginStop();

    public void onPluginPause();

    public void onPluginDestroy();

}
