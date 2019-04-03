package com.bkozyrev.superchat.chat.presentation.view;

import com.bkozyrev.superchat.core.presentation.view.MvpView;

/**
 * Интерфейс View чата
 *
 * @author Kozyrev Boris
 */
public interface ChatMvpView extends MvpView {

    /**
     * Пользователь произвел разлогин
     */
    void signOut();
}
