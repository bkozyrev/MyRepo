package com.bkozyrev.superchat.login.di.modules;

import com.bkozyrev.superchat.core.rx.IRxSchedulers;
import com.bkozyrev.superchat.login.data.AuthRepository;
import com.bkozyrev.superchat.login.di.scopes.LoginScope;
import com.bkozyrev.superchat.login.domain.LoginInteractor;
import com.bkozyrev.superchat.login.presentation.presenter.LoginPresenter;
import com.google.firebase.auth.FirebaseAuth;
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
    static LoginPresenter provideLoginPresenter(IRxSchedulers rxSchedulers) {
        return new LoginPresenter(new LoginInteractor(new AuthRepository(FirebaseAuth.getInstance()), rxSchedulers));
    }
}
