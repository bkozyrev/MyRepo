package com.bkozyrev.superchat.core.data;

import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * Репозиторий регистрации пользователя
 *
 * @author Kozyrev Boris
 */
public interface IAuthRepository {

    /**
     * Подписаться на изменения состояния авторизации
     *
     * @return {@link Observable} с состоянием авторизации {@link AuthState}
     */
    Observable<AuthState> observeAuthState();

    /**
     * Произвести разлогин
     */
    void signOut();
}
