package com.bkozyrev.superchat.core.data;

/**
 * Возможные состояния авторизации пользователя
 *
 * @author Kozyrev Boris
 */
public enum AuthState {
    /**
     * Пользователь не авторизован
     */
    SIGNED_OUT,

    /**
     * Пользователь авторизован с помощью гугл аккаунта
     */
    SIGNED_WITH_GOOGLE
}
