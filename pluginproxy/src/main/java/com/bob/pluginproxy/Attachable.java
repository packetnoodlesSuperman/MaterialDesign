package com.bob.pluginproxy;

public interface Attachable<T> {

    void attach(T proxy, PluginApk apk);

}
