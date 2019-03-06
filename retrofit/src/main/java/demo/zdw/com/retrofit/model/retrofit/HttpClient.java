package demo.zdw.com.retrofit.model.retrofit;

import java.util.concurrent.TimeUnit;

import demo.zdw.com.retrofit.model.api.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yidatec on 2019/2/25.
 */

public class HttpClient {

    private static ApiService mApiService;
    private  static Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;

    public static ApiService getApiService() {

        if (mApiService == null) {
            mApiService = getRetrofit().create(ApiService.class);
        }
        return mApiService;
    }


    private static Retrofit getRetrofit() {
        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("http:www.abc.com")
                    .addConverterFactory(GsonConverterFactory.create())//加入数据解析器
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //加入网络请求适配器
                    .client(getHttpClient())
                    .build();
        }
        return mRetrofit;
    }

    private static OkHttpClient getHttpClient() {
        if(mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(getBasicParamsInterceptor()) //设置拦截器
//                    .sslSocketFactory(getSSLSocketFactory(GSKApplication.getInstance()))
//                    .hostnameVerifier(getHostnameVerifier(null))
//                    .retryOnConnectionFailure(true) //失败重连
//                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;
    }

}
