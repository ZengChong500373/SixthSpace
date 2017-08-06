package com.jyh.sixthspace.viewmodel;

import android.util.Log;
import android.util.SparseArray;

import com.jyh.sixthspace.constant.ReCommendConstant;
import com.jyh.sixthspace.http.NetWork;
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
 * Created by Administrator on 2017/4/18.
 */

public class RecommendViewModel extends Observable {
    private SparseArray<List<VideoInfo>> mapInfos;
    public RecommendViewModel() {
        this.mapInfos =new SparseArray<>();
        loadDataFromNet();
    }
    public void loadDataFromNet() {
        NetWork.getVideo().getHomePage().map(new Function<VideoHttpResponse<VideoRes>, SparseArray<List<VideoInfo>>>() {
            @Override
            public SparseArray<List<VideoInfo>> apply(VideoHttpResponse<VideoRes> videoResVideoHttpResponse) throws Exception {
                List<VideoType> list = videoResVideoHttpResponse.getRet().list;
                SparseArray mapList=new SparseArray();
                mapList.put(ReCommendConstant.RECOMMEND_VIEWPAGER,list.get(0).childList);
                mapList.put(ReCommendConstant.RECOMMEND_RECYCLER,list.get(3).childList);
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
                Log.e("error",throwable.toString());
            }
        });

    }

    public void DataChang(SparseArray<List<VideoInfo>> value) {
        mapInfos=value;
        setChanged();
        notifyObservers();
    }

    public SparseArray<List<VideoInfo>> getMapInfos() {
        return mapInfos;
    }
}
