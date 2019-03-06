package demo.zdw.com.mvp.view.model;

import javax.inject.Inject;

import demo.zdw.com.mvp.base.BaseModel;
import demo.zdw.com.mvp.base.IMVPListener;
import demo.zdw.com.mvp.model.api.ApiService;
import demo.zdw.com.mvp.model.entity.SplashEntity;
import demo.zdw.com.mvp.utils.TimeUtil;
import demo.zdw.com.mvp.view.contract.SplashContract;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by yidatec on 2019/2/13.
 */

public class SplashModel extends BaseModel implements SplashContract.Model{
    private ApiService apiService;

    @Inject
    public SplashModel(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getSplash(String deviceId, final IMVPListener<SplashEntity> listener) {
        String client = "android";
        String version = "1.3.0";
        Long time = TimeUtil.getCurrentSeconds();
        apiService.getSplash(client,version,time,deviceId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<SplashEntity>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(SplashEntity splashEntity) {
                        listener.onSuccess(splashEntity);
                    }
                });
    }
}
