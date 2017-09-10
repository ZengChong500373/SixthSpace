package com.jyh.sixthspace;

import android.app.Application;
import android.content.Context;

import com.github.moduth.blockcanary.BlockCanary;
import com.jyh.sixthspace.utlis.AppBlockCanaryContext;
import com.jyh.sixthspace.utlis.CrashHandler;


/**
 * Created by Administrator on 2017/4/8.
 */

public class SixthApplication  extends Application{
    /**
     * 上下文对象
     * */
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        CrashHandler.getInstance().init(mContext);
       /** 检测ui卡顿*/
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }
    /**
     * 全局上下文
     */
    public static Context getContext() {
        return mContext;
    }
}
