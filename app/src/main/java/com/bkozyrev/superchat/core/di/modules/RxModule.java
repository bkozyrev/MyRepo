package com.bkozyrev.superchat.core.di.modules;

import com.bkozyrev.superchat.core.rx.IRxSchedulers;
import com.bkozyrev.superchat.core.rx.IRxSchedulersTransformer;
import com.bkozyrev.superchat.core.rx.RxSchedulers;
import com.bkozyrev.superchat.core.rx.RxSchedulersTransformer;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Dagger-модуль для предоставления зависимостей из пакета io.reactivex
 *
 * @author Козырев Борис
 */
@Module
public interface RxModule {

    @Singleton
    @Provides
    static IRxSchedulers provideRxSchedulers() {
        return new RxSchedulers();
    }

    @Singleton
    @Provides
    static IRxSchedulersTransformer provideRxSchedulersTransformer(IRxSchedulers rxSchedulers) {
        return new RxSchedulersTransformer(rxSchedulers);
    }
}
