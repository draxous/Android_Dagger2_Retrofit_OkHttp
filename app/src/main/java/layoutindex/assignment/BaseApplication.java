package layoutindex.assignment;

import android.app.Application;


import layoutindex.assignment.component.DaggerNetworkComponent;
import layoutindex.assignment.component.NetworkComponent;
import layoutindex.assignment.module.ApplicationModule;
import layoutindex.assignment.module.NetworkModule;

/**
 * Created by rasslk on 11/15/2017.
 */

public class BaseApplication extends Application {

    private NetworkComponent mNetworkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkComponent = DaggerNetworkComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule("http://dev.appslanka.com/"))
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }
}
