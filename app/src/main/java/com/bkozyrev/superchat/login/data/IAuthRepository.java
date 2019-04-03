package com.bkozyrev.superchat.login.data;

import com.bkozyrev.superchat.core.data.AuthState;
import io.reactivex.Observable;

/**
 * Репозиторий регистрации пользователя
 *
 * @author Kozyrev Boris
 */
public interface IAuthRepository {

    /**
     * Подписаться на изменения состояния авторизации
     */
    Observable<AuthState> observeAuthState();
}
