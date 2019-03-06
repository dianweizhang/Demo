package demo.zdw.com.mvp.base;

/**
 * Created by yidatec on 2018/8/14.
 */

public interface IMVPListener<E> {

    /**
     * 成功的时候回调

     */
    void  onSuccess(E data);

    /**
     * 网络失败
     */
    void onNetworkError();

    /**
     * 服务器返回错误
     * @param pErrorCode
     * @param pErrorMessage
     */
    void onServerError(int pErrorCode, String pErrorMessage);
}
