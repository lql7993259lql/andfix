package com.jiaxianghudong.andfix;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * Created by 刘清林 on 2018/4/10.
 * 邮箱:1586864901@qq.com
 */

public class MyApplication extends Application {

    public static PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(),0);
            String version = info.versionName;
            patchManager = new PatchManager(this);
            patchManager.init(version);//current version
            patchManager.loadPatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
