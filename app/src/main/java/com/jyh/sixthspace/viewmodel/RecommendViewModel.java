package com.jyh.sixthspace.viewmodel;

import android.util.Log;
import android.util.SparseArray;

import com.jyh.sixthspace.constant.ReCommendConstant;

import com.jyh.sixthspace.sdk.http.NetWork;
import com.jyh.sixthspace.sdk.model.VideoHttpResponse;
import com.jyh.sixthspace.sdk.model.VideoInfo;
import com.jyh.sixthspace.sdk.model.VideoRes;
import com.jyh.sixthspace.sdk.model.VideoType;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/4/18.
 */

public class RecommendViewModel extends Observable {
    private SparseArray<List<VideoInfo>> mapInfos;

    public RecommendViewModel() {
        this.mapInfos = new SparseArray<>();
        loadDataFromNet();
    }

    public void loadDataFromNet() {
        NetWork.getVideo().getHomePage().map(new Function<VideoHttpResponse<VideoRes>, SparseArray<List<VideoInfo>>>() {
            @Override
            public SparseArray<List<VideoInfo>> apply(VideoHttpResponse<VideoRes> videoResVideoHttpResponse) throws Exception {
                List<VideoType> list = videoResVideoHttpResponse.getRet().list;
                SparseArray mapList = new SparseArray();
                mapList.put(ReCommendConstant.RECOMMEND_VIEWPAGER, filterNoUseData(list, 0));
                mapList.put(ReCommendConstant.RECOMMEND_RECYCLER, filterNoUseData(list, list.size()-3));
                return mapList;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<SparseArray<List<VideoInfo>>>() {
            @Override
            public void accept(SparseArray<List<VideoInfo>> listSparseArray) throws Exception {
                DataChang(listSparseArray);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e("error", throwable.toString());
            }
        });

    }

    public void DataChang(SparseArray<List<VideoInfo>> value) {
        mapInfos = value;
        setChanged();
        notifyObservers();
    }

    public SparseArray<List<VideoInfo>> getMapInfos() {
        return mapInfos;
    }
   List<VideoInfo> filterList;
    public List<VideoInfo> filterNoUseData(List<VideoType> list, int position) {
         filterList = new ArrayList<>();
        if (list.size() < position) {
            return filterList;
        }
        for (int i = 0; i < list.get(position).childList.size(); i++) {
            VideoInfo info = list.get(position).childList.get(i);
            String loadType = info.getLoadType();
            if ("video".equalsIgnoreCase(loadType)||"videoList".equalsIgnoreCase(loadType)) {
                filterList.add(info);
            }

        }
        if (filterList.size() <= 3 && list.size() >= position + 2) {
            filterNoUseData(list, position + 1);
        }
        return filterList;
    }


}
