package com.jyh.sixthspace.view.activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.jyh.sixthspace.R;
import com.jyh.sixthspace.sdk.base.BaseActivity;
import com.jyh.sixthspace.databinding.ActvityMoviesTypeListBinding;
import com.jyh.sixthspace.sdk.bean.movie.VideoInfo;
import com.jyh.sixthspace.sdk.bean.movie.VideoType;
import com.jyh.sixthspace.view.adapter.MoviesTpyeListAdapter;
import com.jyh.sixthspace.viewmodel.MoviesTpyeListViewModel;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/5/15.
 *
 */

public class MoviesTpyeListActivity extends BaseActivity implements Observer{
    private ActvityMoviesTypeListBinding binding;
    private MoviesTpyeListAdapter adapter;
    private VideoInfo info;
    private MoviesTpyeListViewModel model;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        binding= DataBindingUtil.setContentView(this, R.layout.actvity_movies_type_list);
        binding.recyclerMovies.setLayoutManager( new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        adapter=new MoviesTpyeListAdapter();
        binding.recyclerMovies.setAdapter(adapter);
    }
    private void initData() {
        info = (VideoInfo) getIntent().getSerializableExtra("videoInfo");
        binding.toolBar.setTitle(info.title);
        model=new MoviesTpyeListViewModel(info);
        model.addObserver(this);
        binding.setModel(model);
    }

    @Override
    public void update(Observable observable, Object object) {
        if (observable instanceof MoviesTpyeListViewModel){
            List<VideoType> list= (List<VideoType>) object;
            adapter.dataAppend(list);
        }

    }
}
