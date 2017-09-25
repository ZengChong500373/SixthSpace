package com.jyh.sixthspace.sdk;

import android.content.Context;

import com.github.moduth.blockcanary.BlockCanary;
import com.jyh.sixthspace.sdk.utlis.AppBlockCanaryContext;
import com.jyh.sixthspace.sdk.utlis.CrashHandler;

/**
 * Created by Administrator on 2017/9/26.
 */

public class SixthSpaceSdk {
    /**
     * 上下文对象
     * */
    private static Context mContext;
    public static void init(Context initContext){
        mContext=initContext;
        CrashHandler.getInstance().init(mContext);
        /** 检测ui卡顿*/
        BlockCanary.install(initContext, new AppBlockCanaryContext()).start();
    }
    /**
     * 全局上下文
     */
    public static Context getContext() {
        return mContext;
    }
}
