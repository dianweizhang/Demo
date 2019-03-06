package demo.zdw.com.mvp.view.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import demo.zdw.com.mvp.R;
import demo.zdw.com.mvp.app.MyApplication;
import demo.zdw.com.mvp.base.BaseActivity;
import demo.zdw.com.mvp.di.components.DaggerSplashComponent;
import demo.zdw.com.mvp.di.modules.SplashModule;
import demo.zdw.com.mvp.view.contract.SplashContract;
import demo.zdw.com.mvp.view.presenter.SplashPresenter;


/**
 * Created by yidatec on 2019/2/1.
 */

public class SplashActivity extends BaseActivity<SplashContract.Presenter> implements SplashContract.View{

    private TextView tvUserName;
    private EditText etUserPassWord;
    @Inject
    SplashPresenter splashPresenter;
//
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        splashPresenter.getSplash("");

//        Button dd = (Button)findViewById(R.id.dd);
//        dd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setData(Uri.parse("launcher://dev/main"));
//                startActivity(intent);
//            }
//        });

    }

    private void initView() {
        tvUserName = findViewById(R.id.tv_user_name);
        etUserPassWord = findViewById(R.id.et_user_password);
    }

    @Override
    protected SplashContract.Presenter getPresenter() {
        DaggerSplashComponent.builder().splashModule(new SplashModule()).
                netComponent(MyApplication.getInstance().getNetComponent()).build().inject(this);
        return splashPresenter;
    }
}
