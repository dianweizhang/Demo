package operationbot.yi.com.rxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rxjava.retorfit.okhttp.demo.http.OnSuccessAndFaultSub;
import com.rxjava.retorfit.okhttp.demo.listener.OnSuccessAndFaultListener;
import com.rxjava.retorfit.okhttp.demo.model.WeatherModel;
import com.rxjava.retorfit.okhttp.demo.view.activity.CreateOperatorActivity;
import com.rxjava.retorfit.okhttp.demo.view.activity.FlatMapOperatorActivity;
import com.rxjava.retorfit.okhttp.demo.view.activity.MapOperatorActivity;
import com.rxjava.retorfit.okhttp.demo.view.activity.RxOperatorMainActivity;
import com.rxjava.retorfit.okhttp.demo.view.activity.ZipOperatorActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tongbu();
        yibu();

        WeatherModel.getWeatherDataForBody("上海", new OnSuccessAndFaultSub(this, new OnSuccessAndFaultListener<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onFault(int code, String errorMsg) {

            }
        }));
    }

    public void create(View view){
        Intent intent = new Intent(this, CreateOperatorActivity.class);
        startActivity(intent);
    }

    public void flat(View view) {
        Intent intent = new Intent(this, FlatMapOperatorActivity.class);
        startActivity(intent);
    }

    public void map(View view) {
        Intent intent = new Intent(this, MapOperatorActivity.class);
        startActivity(intent);
    }

    public void rx(View view) {
        Intent intent = new Intent(this, RxOperatorMainActivity.class);
        startActivity(intent);
    }

    public void zip(View view) {
        Intent intent = new Intent(this, ZipOperatorActivity.class);
        startActivity(intent);
    }

    Disposable mDisposable;
    private void tongbu() {
        Observable novel=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        });


        Observer<String> reader=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable=d;
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(String value) {
                if ("2".equals(value)){
                    mDisposable.dispose();
                    return;
                }
                Log.e(TAG,"onNext:"+value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError="+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete()");
            }
        };

        novel.subscribe(reader);
    }

    private void yibu() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("连载1");
                emitter.onNext("连载2");
                emitter.onNext("连载3");
                emitter.onComplete();
            }
        })
                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribeOn(Schedulers.io())//执行在io线程
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG,"onNext:"+value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError="+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete()");
                    }
                });
    }


}
