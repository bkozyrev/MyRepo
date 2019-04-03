package com.bkozyrev.superchat.chat.di.modules;

import com.bkozyrev.superchat.chat.di.scopes.ChatScope;
import com.bkozyrev.superchat.chat.presentation.presenter.ChatPresenter;
import com.bkozyrev.superchat.login.domain.AuthInteractor;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger-модуль экрана чата
 *
 * @author Kozyrev Boris
 */
@Module
public interface ChatActivityModule {

    @Provides
    @ChatScope
    static ChatPresenter provideChatPresenter(AuthInteractor authInteractor) {
        return new ChatPresenter(authInteractor);
    }
}
