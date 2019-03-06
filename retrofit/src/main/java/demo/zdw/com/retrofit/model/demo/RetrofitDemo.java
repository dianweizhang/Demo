package demo.zdw.com.retrofit.model.demo;

import demo.zdw.com.retrofit.model.retrofit.HttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by yidatec on 2019/2/25.
 */

public class RetrofitDemo {

    /**
     * 通过Retrofit自带的网络请求适配器CallAdapter来实现网络请求
     */
    private void request() {
        Call<ResponseBody> call = HttpClient.getApiService().getResponseBody1();
        call.enqueue(new Callback<ResponseBody>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
            }
        });
    }

    /**
     * 通过RxJava来实现网络请求
     */
    private void request2() {
        HttpClient.getApiService().testRxJava()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(ResponseBody responseBody) {
                    }
                });
    }
}
