package com.bob.pluginproxy;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.imooc.com/article/details/id/252238
 */
public class PluginManager {

    public static final String PLUGIN_CLASS_NAME = "plugin_class_name";
    public static final String PACKAGE_NAME = "package_name";

    //单例
    static final class PluginManagerHolder {
        static final PluginManager sManager = new PluginManager();
    }

    public static PluginManager getInstance() { return PluginManagerHolder.sManager; }

    private static Context mContext;
    //缓存
    Map<String, PluginApk> map = new HashMap<>();

    public PluginApk getPluginApk(String packageName) {
        return map.get(packageName);
    }

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    public final void loadApk(String apkPath) {
        PackageInfo packageInfo = queryPackageInfo(apkPath);

        if (packageInfo == null) {
            return;
        }

        if (TextUtils.isEmpty(packageInfo.packageName)) {
            return;
        }

        PluginApk pluginApk = map.get(packageInfo.packageName);

        if (pluginApk == null) {
            loadApk(pluginApk, apkPath, packageInfo);
        }

    }

    public void startActivity(Intent intent) {
        Intent pluginIntent = new Intent(mContext, ProxyActivity.class);
        Bundle extra = intent.getExtras();

        if (extra == null || !extra.containsKey(PLUGIN_CLASS_NAME) && !extra.containsKey(PACKAGE_NAME)) {
            try {
                throw new IllegalAccessException("lack class of plugin and package name");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        pluginIntent.putExtras(intent);
        pluginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(pluginIntent);
    }


    private void loadApk(PluginApk pluginApk, String apkPath, PackageInfo packageInfo) {
        pluginApk = createApk(apkPath);
    }

    private PluginApk createApk(String apkPath) {
        return null;
    }

    private PackageInfo queryPackageInfo(String apkPath) {
        PackageInfo packageInfo =
                mContext.getPackageManager().getPackageArchiveInfo(
                        apkPath,
                        PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES
                );
        return packageInfo;
    }
}
