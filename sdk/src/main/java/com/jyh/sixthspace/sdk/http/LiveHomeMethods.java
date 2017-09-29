package com.jyh.sixthspace.sdk.http;




import com.jyh.sixthspace.sdk.bean.live.HomeCateList;
import com.jyh.sixthspace.sdk.bean.live.HttpResponse;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;




/**
 * 作者：gaoyin
 * 电话：18810474975
 * 邮箱：18810474975@163.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 修改时间：2016/12/12 下午4:12
 **/
public interface LiveHomeMethods {

    /**
     * 首页分类列表
     *
     * @return
     */
    @GET("/api/homeCate/getCateList")
    Observable<HttpResponse<List<HomeCateList>>> getHomeCateList(@QueryMap Map<String, String> params);


}
