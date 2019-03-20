package com.bkozyrev.superchat.core;

import android.app.Activity;
import android.app.Application;
import com.bkozyrev.superchat.core.di.component.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import javax.inject.Inject;

/**
 * Application-класс всего приложения
 *
 * @author Козырев Борис
 */
public class ProjectApplication extends Application implements HasActivityInjector {

    // инжектор для поставки зависимостей в андроид компоненты
    @Inject
    DispatchingAndroidInjector<Activity> mDispatchingActivityInjector;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().create(this).inject(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mDispatchingActivityInjector;
    }
}
