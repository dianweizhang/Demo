package demo.zdw.com.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by yidatec on 2018/8/13.
 */

public abstract class BaseActivity <P extends BasePresenter> extends Activity implements IBaseView{

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
//        创建Presenter
        mPresenter = getPresenter();
        if(mPresenter != null) {
            //关联View
            mPresenter.attachModelView(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null) {
            mPresenter.onDettach();
        }
    }

    @Override
    public void showLoading(String tag, String msg) {
        if (this.isFinishing()) {
            return;
        }
    }

    @Override
    public void hideLoading(String tag) {
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError(String tag, String message) {
        hideLoading(tag);
        showToast("网络异常，请稍后重试");
    }


    @Override
    public void onServerError(String tag, int pErrorCode, String pErrorMessage) {
        hideLoading(tag);
        if(!TextUtils.isEmpty(pErrorMessage)) {
            showToast(pErrorMessage);
        }
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    protected abstract P getPresenter();
}
