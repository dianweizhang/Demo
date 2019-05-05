package com.rxjava.retorfit.okhttp.demo.listener;

/**
 * 网络回调
 */
public interface OnSuccessAndFaultListener<T> {
    void onSuccess(T result);

    /**
     *
     * @param code -1:网络错误
     * @param errorMsg
     */
    void onFault(int code,String errorMsg);
//
//    void onNetError(int code, String errorMsg);
}
