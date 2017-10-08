package com.jyh.sixthspace.live.ui.activity;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.google.gson.Gson;
import com.jyh.sixthspace.live.R;
import com.jyh.sixthspace.live.databinding.ActivityLiveBinding;

import com.jyh.sixthspace.sdk.base.BaseActivity;
import com.jyh.sixthspace.sdk.bean.live.TempLiveVideoInfo;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/10/9.
 */

public class LiveActivity extends BaseActivity {
    private ActivityLiveBinding binding;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    private String Room_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live);
        initView();
        initData();
    }


    private void initView() {
        jcVideoPlayerStandard = binding.videoplayer;
        jcVideoPlayerStandard.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        jcVideoPlayerStandard.titleTextView.setVisibility(View.GONE);

    }

    private void initData() {
        Room_id = getIntent().getExtras().getString("Room_id");


        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        String str = "https://m.douyu.com/html5/live?roomId=" + Room_id;

        Request requestPost = new Request.Builder()
//                .url(NetWorkApi.oldBaseUrl+ NetWorkApi.getOldLiveVideo+ room_id + "?rate=0")
                .url(str)
                .get()
                .build();
        client.newCall(requestPost).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.e("error", e.getMessage() + "---");

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String json = response.body().string().toString();
                Log.e("onResponse", json);
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    if (jsonObject.getInt("error") == 0) {
                        Gson gson = new Gson();
                        TempLiveVideoInfo mLiveVideoInfo = gson.fromJson(json, TempLiveVideoInfo.class);
                        show(mLiveVideoInfo.getData().getHls_url());
                    } else {

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void show(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                jcVideoPlayerStandard.setUp(str
                        , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
                jcVideoPlayerStandard.changeUiToPlayingShow();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (jcVideoPlayerStandard.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        jcVideoPlayerStandard.releaseAllVideos();
    }
}
