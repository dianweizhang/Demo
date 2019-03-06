package demo.zdw.com.mvp.di.components;

import javax.inject.Singleton;

import dagger.Component;
import demo.zdw.com.mvp.di.modules.NetModule;
import demo.zdw.com.mvp.model.api.ApiService;

/**
 * Created by yidatec on 2019/1/31.
 */

@Component(modules = NetModule.class)
@Singleton
public interface NetComponent {
    ApiService getApiService();
//    OkHttpClient getOkHttp();
//    Retrofit getRetrofit();
}
