package com.bkozyrev.superchat.core.di.modules;

import com.bkozyrev.superchat.core.data.AuthRepository;
import com.bkozyrev.superchat.core.rx.IRxSchedulers;
import com.bkozyrev.superchat.login.domain.AuthInteractor;
import com.google.firebase.auth.FirebaseAuth;
import dagger.Module;
import dagger.Provides;

/**
 * Модуль общих зависимостей
 *
 * @author Kozyrev Boris
 */
@Module
public interface CommonModule {

    @Provides
    static AuthInteractor provideAuthInteractor(IRxSchedulers rxSchedulers) {
        return new AuthInteractor(new AuthRepository(FirebaseAuth.getInstance()), rxSchedulers);
    }
}
