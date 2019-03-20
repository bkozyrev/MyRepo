package com.bkozyrev.superchat.core.di.component;

import com.bkozyrev.superchat.core.ProjectApplication;
import com.bkozyrev.superchat.core.di.modules.InjectorsModule;
import com.bkozyrev.superchat.core.di.modules.NetworkModule;
import com.bkozyrev.superchat.core.di.modules.RxModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

/**
 * Компонент приложения, включающий в себя все Dagger-модули базового слоя, необходимые для работы приложения
 *
 * @author Козырев Борис
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, InjectorsModule.class, RxModule.class,
        NetworkModule.class})
public interface AppComponent extends AndroidInjector<ProjectApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ProjectApplication> {
    }
}