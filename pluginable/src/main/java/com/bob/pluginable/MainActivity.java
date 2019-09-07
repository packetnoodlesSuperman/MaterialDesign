package com.bob.pluginable;

import android.content.Intent;
import android.os.Environment;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bob.pluginproxy.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public final static String PLUGIN_NAME = "plugin.apk";
    public final static String PLUGIN_PACKAGE_NAME = "com.bob.pluginable";
    public final static String PLUGIN_CLAZZ_NAME = "com.bob.pluginable.plugin.TestActivity";
    PluginManager mPluginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(PluginManager.PACKAGE_NAME, PLUGIN_PACKAGE_NAME);
                intent.putExtra(PluginManager.PLUGIN_CLASS_NAME, PLUGIN_CLAZZ_NAME);
                mPluginManager.startActivity(intent);
            }
        });
        Utils.verifyStoragePermissions(this);

        PluginManager.init(getApplicationContext());
        mPluginManager = PluginManager.getInstance();
//        String pluginApkPath = Environment.getExternalStorageDirectory() +
//                File.separator + "plugins" + File.separator + PLUGIN_NAME;
        String pluginApkPath = getCacheDir() + File.separator + PLUGIN_NAME;


        mPluginManager.loadApk(pluginApkPath);
    }
}
