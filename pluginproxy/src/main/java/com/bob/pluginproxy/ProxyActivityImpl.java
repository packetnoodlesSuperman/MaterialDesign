package com.bob.pluginproxy;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import java.lang.reflect.Constructor;

public class ProxyActivityImpl implements Pluginable {

    Activity mProxy;

    String mPluginClazz;
    PluginApk mPluginApk;
    PluginActivity mPlugin;
    Resources mResources;
    Resources.Theme mTheme;

    public ProxyActivityImpl(ProxyActivity activity) {
        mProxy = activity;
    }

    @Override
    public void onPluginCreate(Bundle bundle) {
        mPluginClazz = bundle.getString(PluginManager.PLUGIN_CLASS_NAME);
        String packageName = bundle.getString(PluginManager.PACKAGE_NAME);

        mPluginApk = PluginManager.getInstance().getPluginApk(packageName);

        try {
            mPlugin = (PluginActivity) loadPluginable(mPluginApk.classLoader, mPluginClazz);
            mPlugin.attach(mProxy, mPluginApk);
            mResources = mPluginApk.pluginRes;
            mPlugin.onCreate(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPluginStart() {
        if (mPlugin != null) {
            mPlugin.onPluginStart();
        }
    }

    @Override
    public void onPluginResume() {
        mPlugin.onPluginResume();
    }

    @Override
    public void onPluginStop() {
        mPlugin.onPluginStop();
    }

    @Override
    public void onPluginPause() {
        mPlugin.onPluginPause();
    }

    @Override
    public void onPluginDestroy() {
        mPlugin.onPluginDestroy();
    }

    public Resources getResources() {
        return mResources;
    }

    public Resources.Theme getTheme() {
        return mTheme;
    }

    public AssetManager getAssets() {
        return mResources.getAssets();
    }

    private Object loadPluginable(ClassLoader classLoader, String pluginActivityClass)
            throws Exception {
        Class<?> pluginClz = classLoader.loadClass(pluginActivityClass);
        Constructor<?> constructor = pluginClz.getConstructor(new Class[] {});
        constructor.setAccessible(true);
        return constructor.newInstance(new Object[] {});
    }
}
