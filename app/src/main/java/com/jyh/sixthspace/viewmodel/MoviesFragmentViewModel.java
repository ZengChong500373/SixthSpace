package com.jyh.sixthspace.viewmodel;


import com.jyh.sixthspace.R;
import com.jyh.sixthspace.base.RequestCallBack;
import com.jyh.sixthspace.model.VideoInfo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 * <p>
 * "moreURL":"http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e539700019",
 * title":"热点资讯",
 * <p>
 * "moreURL":"http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e53843000b",
 * "title":"精彩推荐",
 * <p>
 * "moreURL":"http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e538140009",
 * "title":"好莱坞",
 * <p>
 * "moreURL":"http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e538ea0012",
 * "title":"微电影",
 * <p>
 * "moreURL":"http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=ff8080815b9075a6015b94ef79dc0284",
 * "title":"香港映象",
 * <p>
 * "moreURL":"http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=402834815584e463015584e538d30011",
 * "title":"午夜剧场",
 */

public class MoviesFragmentViewModel {
    private RequestCallBack<List<VideoInfo>> callBack;

    public MoviesFragmentViewModel(RequestCallBack<List<VideoInfo>> callBack) {
        this.callBack = callBack;
        initData();
    }

    public void initData() {
        List<VideoInfo> list = new ArrayList<>();
        list.add(new VideoInfo("精彩推荐", R.drawable.moives_recmmend,"402834815584e463015584e53843000b"));
        list.add(new VideoInfo("好莱坞", R.drawable.movies_hollywood,"402834815584e463015584e538140009"));
        list.add(new VideoInfo("香港映象", R.drawable.movies_hongkong_film,"ff8080815b9075a6015b94ef79dc0284"));
        list.add(new VideoInfo("午夜剧场", R.drawable.movies_midnite_matinee,"402834815584e463015584e538d30011"));
        list.add(new VideoInfo("微电影", R.drawable.movies_micro_film,"402834815584e463015584e538ea0012"));
        list.add(new VideoInfo("热点资讯", R.drawable.movies_entertainment_information,"402834815584e463015584e539700019"));
        callBack.onRequestSuccess(list);
    }
}
