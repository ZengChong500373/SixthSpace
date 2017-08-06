package com.jyh.sixthspace.viewmodel;

import android.util.Log;
import android.util.SparseArray;

import com.jyh.sixthspace.constant.ReCommendConstant;
import com.jyh.sixthspace.http.NetWork;
import com.jyh.sixthspace.http.VideoMethods;
import com.jyh.sixthspace.model.VideoHttpResponse;
import com.jyh.sixthspace.model.VideoInfo;
import com.jyh.sixthspace.model.VideoRes;
import com.jyh.sixthspace.model.VideoType;

import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/5/15.
 */

public class MoviesTpyeListViewModel extends Observable {
    private VideoInfo info;
    private int pageCount = 1;

    public MoviesTpyeListViewModel(VideoInfo info) {
        this.info = info;
        getData();
    }

    public void getData() {
        NetWork.getVideo().getVideoList(info.getCatalogId(), pageCount + "").map(new Function<VideoHttpResponse<VideoRes>, List<VideoType>>() {
            @Override
            public List<VideoType> apply(VideoHttpResponse<VideoRes> videoResVideoHttpResponse) throws Exception {
                return videoResVideoHttpResponse.getRet().list;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<VideoType>>() {
            @Override
            public void accept(List<VideoType> videoTypes) throws Exception {
               dealData(videoTypes);
                pageCount++;
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }

    public void dealData(List<VideoType> videoInfos) {
        setChanged();
        notifyObservers(videoInfos);
    }
}
