package com.bkozyrev.superchat.login.domain;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.data.AuthState;
import com.bkozyrev.superchat.core.rx.IRxSchedulers;
import com.bkozyrev.superchat.login.data.IAuthRepository;
import io.reactivex.Observable;

/**
 * Интерактор, содержащий в себе бизнес логику регистрации
 *
 * @author Kozyrev Boris
 */
public class LoginInteractor {

    private final IAuthRepository mLoginRepository;
    private final IRxSchedulers mRxSchedulers;

    public LoginInteractor(@NonNull IAuthRepository loginRepository, @NonNull IRxSchedulers rxSchedulers) {
        mLoginRepository = loginRepository;
        mRxSchedulers = rxSchedulers;
    }

    public Observable<AuthState> observeAuthState() {
        return mLoginRepository
                .observeAuthState()
                .subscribeOn(mRxSchedulers.getIOScheduler())
                .observeOn(mRxSchedulers.getMainThreadScheduler());
    }
}
