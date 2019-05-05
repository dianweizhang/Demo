package com.rxjava.retorfit.okhttp.demo.model;

import com.rxjava.retorfit.okhttp.demo.bean.BaseRequestBean;
import com.rxjava.retorfit.okhttp.demo.bean.WeatherRequestBean;
import com.rxjava.retorfit.okhttp.demo.http.RetrofitFactory;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * Created by yidatec on 2019/5/5.
 */

public class WeatherModel {
    /**
     * 获取天气数据@Query
     */
    public static void getWeatherDataForQuery(String cityName,DisposableObserver<ResponseBody> subscriber) {
        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().getWeatherDataForQuery("v1",cityName);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

    /**
     * 获取天气数据@QueryMap
     */
    public static void getWeatherDataForMap(String cityName,DisposableObserver<ResponseBody> subscriber) {
        Map<String,String> map = new HashMap<>();
        map.put("version","v1");
        map.put("city",cityName);
        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().getWeatherDataForMap(map);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }

    /**
     * 获取天气数据@Body
     */
    public static void getWeatherDataForBody(String cityName,DisposableObserver<ResponseBody> subscriber) {
        WeatherRequestBean bean = new WeatherRequestBean();
        bean.setCity(cityName);
        BaseRequestBean<WeatherRequestBean> requestBean = new BaseRequestBean<>();
        requestBean.setObj(bean);
        Observable<ResponseBody> observable =  RetrofitFactory.getInstance().getHttpApi().getWeatherDataForBody(requestBean);
        RetrofitFactory.getInstance().toSubscribe(observable, subscriber);
    }
}
