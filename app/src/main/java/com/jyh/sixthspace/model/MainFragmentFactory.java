package com.jyh.sixthspace.model;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.jyh.sixthspace.view.fragment.MoviesFragment;
import com.jyh.sixthspace.view.fragment.LiveFragment;
import com.jyh.sixthspace.view.fragment.RecommendFragment;
import com.jyh.sixthspace.view.fragment.TeleVisionFragment;

/**
 * Created by Administrator on 2017/4/13.
 */

public class MainFragmentFactory {
  private  static   SparseArray<Fragment>  map=new SparseArray<>();
    public static Fragment getFragment(int posistion){
        Fragment  currentFragment=map.get(posistion) ;
          if (currentFragment==null){
              switch (posistion){
                  case 0:
                    map.put(0,new RecommendFragment());
                      break;
                  case 1:
                      map.put(1,new MoviesFragment());
                      break;
                  case 2:
                      map.put(2,new TeleVisionFragment());
                      break;
                  case 3:
                      map.put(3,new LiveFragment());
                      break;
                  default:
                      break;
              }
              currentFragment=map.get(posistion);
          }
        return currentFragment;
    }
}
