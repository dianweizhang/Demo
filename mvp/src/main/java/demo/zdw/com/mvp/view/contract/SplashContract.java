package demo.zdw.com.mvp.view.contract;


import demo.zdw.com.mvp.base.BasePresenter;
import demo.zdw.com.mvp.base.IBaseModel;
import demo.zdw.com.mvp.base.IBaseView;
import demo.zdw.com.mvp.base.IMVPListener;
import demo.zdw.com.mvp.model.entity.SplashEntity;

/**
 * Created by Mr.Yangxiufeng
 * DATE 2016/7/22
 * owspace
 */
public interface SplashContract {
    abstract class Presenter extends BasePresenter<View> {
        public abstract void getSplash(String deviceId);
    }
    interface View extends IBaseView {

    }

    interface Model extends IBaseModel {
        void getSplash(String deviceId, IMVPListener<SplashEntity> listener);
    }

}
