package com.example.jh.taokelink.api;

import com.example.jh.taokelink.entity.RiderBean;
import com.example.jh.taokelink.http.BaseResponse;
import com.example.jh.taokelink.http.RetrofitHelper;
import com.example.jh.taokelink.http.RxUtils;

import rx.Observable;


/**
 * 作者： Created by${raojianhui}
 * 日期：2018/8/13  11:29.
 * 项目：FrameDemo
 * 包名：com.example.jh.taokelink.api
 * 描述：
 */

public class OkhttpSource implements ApiService {

    private static volatile OkhttpSource instance = null;

    private ApiService getApi() {
        return RetrofitHelper.getInstance().createApi(ApiService.class);
    }

    public static OkhttpSource getInstance() {
        if (instance == null) {
            synchronized (OkhttpSource.class) {
                if (instance == null) {
                    instance = new OkhttpSource();
                }
            }
        }
        return instance;
    }


    @Override
    public Observable<BaseResponse<RiderBean>> getSalesSellerEntryList() {
        return getApi().getSalesSellerEntryList().compose(RxUtils.<BaseResponse<RiderBean>>rxSchedulerHelper());
    }
}
