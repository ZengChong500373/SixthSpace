package com.jyh.sixthspace.utlis;

import android.widget.Toast;
import com.jyh.sixthspace.SixthApplication;


/**
 * Created by sunxx on 2016/8/3.
 */
public class ToastUtils {
    private static ToastUtils toastUtils;
    private ToastUtils() {
    }
    public static ToastUtils getInstance() {
        if (toastUtils==null){
            toastUtils=new ToastUtils();
        }
        return toastUtils;
    }

    public void show(String str) {
        Toast.makeText(SixthApplication.getContext(), str, Toast.LENGTH_LONG).show();
    }
}
