package com.jyh.sixthspace.view.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jyh.sixthspace.R;

import com.jyh.sixthspace.databinding.FragmentMovieBinding;
import com.jyh.sixthspace.sdk.base.LazyFragment;
import com.jyh.sixthspace.sdk.base.RequestCallBack;
import com.jyh.sixthspace.sdk.bean.movie.VideoInfo;
import com.jyh.sixthspace.view.adapter.MoviesRecyclerAdapter;
import com.jyh.sixthspace.viewmodel.MoviesFragmentViewModel;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class MoviesFragment extends LazyFragment<FragmentMovieBinding> implements RequestCallBack<List<VideoInfo>> {
    private MoviesRecyclerAdapter adapter;
    private MoviesFragmentViewModel viewModel;

    @Override
    public int setFragmentView() {
        return R.layout.fragment_movie;
    }

    @Override
    public void initViews() {
        jyhBinding.recyclerMovies.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MoviesRecyclerAdapter();
        jyhBinding.recyclerMovies.setAdapter(adapter);
        ((AppCompatActivity) getActivity()).setSupportActionBar(jyhBinding.toolBar);
        jyhBinding.toolBar.inflateMenu(R.menu.main_menu);
        jyhBinding.toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.action_main_search:
                        //     intent = new Intent(getActivity(), MainActivity.class);
                        break;
                    case R.id.action_main_collection:
                        //   intent = new Intent(getActivity(), MainActivity.class);
                        break;
                }
                startActivity(intent);
                return false;
            }
        });
    }

    @Override
    public void onFirstUserVisible() {
        viewModel = new MoviesFragmentViewModel(this);
        jyhBinding.setModel(viewModel);
    }


    @Override
    public void onRequestSuccess(List<VideoInfo> videoInfos) {
        adapter.setData(videoInfos);
    }
}
