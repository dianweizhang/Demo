package demo.zdw.com.mvp.base;


import java.lang.ref.WeakReference;

/**
 * Created by yidatec on 2018/8/13.
 */

public abstract class BasePresenter<V extends IBaseView> {

    public WeakReference<V> mViewRef;


    public void attachModelView( V pView) {
        mViewRef = new WeakReference<V>(pView);
    }


    public V getView() {
        if (isAttach()) {
            return mViewRef.get();
        } else {
            return null;
        }
    }

    public boolean isAttach() {
        return null != mViewRef && null != mViewRef.get();
    }


    public void onDettach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}