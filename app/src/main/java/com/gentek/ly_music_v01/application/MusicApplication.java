package com.gentek.ly_music_v01.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gentek.lib_audio.app.AudioHelper;


public class MusicApplication extends Application {

    private static MusicApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;

        //音频SDK初始化
        AudioHelper.init(this);
        //ARouter初始化
        //ARouter.init(mApplication);
    }

    public static MusicApplication getInstance() {
        return mApplication;
    }
}
