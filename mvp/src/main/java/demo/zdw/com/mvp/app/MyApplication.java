package demo.zdw.com.mvp.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import demo.zdw.com.mvp.di.components.DaggerNetComponent;
import demo.zdw.com.mvp.di.components.NetComponent;
import demo.zdw.com.mvp.di.modules.NetModule;

/**
 * Created by yidatec on 2019/2/14.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    private NetComponent netComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initNet();

        //内存泄漏工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }


    private void initNet() {
        netComponent =  DaggerNetComponent.builder().netModule(new NetModule()).build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
