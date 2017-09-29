package com.jyh.sixthspace.live;


import com.jyh.sixthspace.live.databinding.FragmentLiveBinding;
import com.jyh.sixthspace.sdk.base.LazyFragment;
import com.jyh.sixthspace.sdk.bean.live.HomeCateList;
import com.jyh.sixthspace.sdk.bean.live.HttpResponse;
import com.jyh.sixthspace.sdk.http.LiveHomeMethods;
import com.jyh.sixthspace.sdk.http.NetWork;
import com.jyh.sixthspace.sdk.utlis.ToastUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/4/13.
 */

public class LiveFragment extends LazyFragment<FragmentLiveBinding> {
    @Override
    public int setFragmentView() {
        return R.layout.fragment_live;
    }

    @Override
    public void onFirstUserVisible() {
        NetWork.LiveBuilder(LiveHomeMethods.class).getHomeCateList(getParamsMap()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HttpResponse<List<HomeCateList>>>() {
            @Override
            public void accept(HttpResponse<List<HomeCateList>> listHttpResponse) throws Exception {

                ToastUtils.getInstance().show("accept");
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                ToastUtils.getInstance().show("Exception");
            }
        });
        jyhBinding.tvDemo.setText("LiveFragment nimabi");
    }
    public  Map<String, String> getParamsMap() {
        Map<String, String> paramsmap = new LinkedHashMap<>();
        paramsmap.put("client_sys", "android");
        paramsmap.put("aid", "android1");
        paramsmap.put("time",System.currentTimeMillis()+"");
        return paramsmap;
    }
}
