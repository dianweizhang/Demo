package demo.zdw.com.mvp.view.presenter;

import javax.inject.Inject;

import demo.zdw.com.mvp.base.IMVPListener;
import demo.zdw.com.mvp.model.entity.SplashEntity;
import demo.zdw.com.mvp.view.contract.SplashContract;
import demo.zdw.com.mvp.view.model.SplashModel;


/**
 * Created by yidatec on 2019/2/1.
 */

public class SplashPresenter extends SplashContract.Presenter {

    private SplashModel splashModel;

    @Inject
    public SplashPresenter(SplashModel splashModel) {
        this.splashModel = splashModel;
    }

    @Override
    public void getSplash(String deviceId) {
        splashModel.getSplash(deviceId, new IMVPListener<SplashEntity>() {
            @Override
            public void onSuccess(SplashEntity data) {
                SplashContract.View v = getView();
            }

            @Override
            public void onNetworkError() {

            }

            @Override
            public void onServerError(int pErrorCode, String pErrorMessage) {

            }
        });
    }
}
