package demo.zdw.com.mvp.di.components;

import dagger.Component;
import demo.zdw.com.mvp.di.modules.SplashModule;
import demo.zdw.com.mvp.di.scopes.UserScope;
import demo.zdw.com.mvp.view.activity.SplashActivity;

/**
 * Created by yidatec on 2019/2/1.
 */
@UserScope
@Component(modules = SplashModule.class,dependencies = NetComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);
}
