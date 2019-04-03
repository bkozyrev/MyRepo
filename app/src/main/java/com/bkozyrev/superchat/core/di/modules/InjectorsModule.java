package com.bkozyrev.superchat.core.di.modules;

import com.bkozyrev.superchat.chat.di.modules.ChatActivityModule;
import com.bkozyrev.superchat.chat.di.scopes.ChatScope;
import com.bkozyrev.superchat.chat.presentation.view.ChatActivity;
import com.bkozyrev.superchat.login.di.modules.LoginActivityModule;
import com.bkozyrev.superchat.login.di.scopes.LoginScope;
import com.bkozyrev.superchat.login.presentation.view.LoginActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Dagger-модуль, предоставляющий зависимости всем компонентам приложения
 *
 * @author Козырев Борис
 */
@Module
public abstract class InjectorsModule {

    @ChatScope
    @ContributesAndroidInjector(modules = ChatActivityModule.class)
    abstract ChatActivity chatActivityInjector();

    @LoginScope
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivityInjector();
}
