package demo.zdw.com.mvp.base;

import android.content.Context;

/**
 * Created by yidatec on 2018/8/13.
 */

public interface IBaseView {

    /**
     * 显示正在加载view
     */
    void showLoading(String tag, String msg);
    /**
     * 关闭正在加载view
     */
    void hideLoading(String tag);
    /**
     * 显示提示
     * @param msg
     */
    void showToast(String msg);
    /**
     * 显示网络
     */
    void showNetworkError(String tag, String message);
    /**
     * 获取上下文
     * @return 上下文
     */
    Context getContext();
    /**
     * 显示请求错误提示
     */
    void onServerError(String tag, int pErrorCode, String pErrorMessage);
}
