package com.bkozyrev.superchat.chat.di.modules;

import com.bkozyrev.superchat.chat.di.scopes.ChatScope;
import com.bkozyrev.superchat.chat.presentation.presenter.ChatPresenter;
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
    static ChatPresenter provideChatPresenter() {
        return new ChatPresenter();
    }
}
