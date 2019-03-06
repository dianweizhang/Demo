package demo.zdw.com.mvp.di.modules;

import dagger.Module;
import dagger.Provides;
import demo.zdw.com.mvp.di.scopes.UserScope;
import demo.zdw.com.mvp.model.api.ApiService;
import demo.zdw.com.mvp.view.contract.SplashContract;
import demo.zdw.com.mvp.view.model.SplashModel;

/**
 * Created by yidatec on 2019/2/1.
 */
@Module
public class SplashModule {


    @Provides
//    @UserScope
    public SplashContract.Model provideModel(ApiService apiService) {
        return new SplashModel(apiService);
    }
}