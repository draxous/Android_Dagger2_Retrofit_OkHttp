package layoutindex.assignment.component;

import javax.inject.Singleton;

import dagger.Component;
import layoutindex.assignment.module.ApplicationModule;
import layoutindex.assignment.module.NetworkModule;
import layoutindex.assignment.ui.MainActivity;

/**
 * Created by rasslk on 11/15/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface NetworkComponent {
        void inject(MainActivity activity);
}
