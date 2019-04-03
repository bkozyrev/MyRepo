package com.bkozyrev.superchat.login.di.modules;

import com.bkozyrev.superchat.login.di.scopes.LoginScope;
import com.bkozyrev.superchat.login.domain.AuthInteractor;
import com.bkozyrev.superchat.login.presentation.presenter.LoginPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger-модуль экрана регистрации пользователя
 *
 * @author Kozyrev Boris
 */
@Module
public interface LoginActivityModule {

    @Provides
    @LoginScope
    static LoginPresenter provideLoginPresenter(AuthInteractor authInteractor) {
        return new LoginPresenter(authInteractor);
    }
}
