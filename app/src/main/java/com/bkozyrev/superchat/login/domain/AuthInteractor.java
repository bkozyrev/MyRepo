package com.bkozyrev.superchat.login.domain;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.data.AuthState;
import com.bkozyrev.superchat.core.rx.IRxSchedulers;
import com.bkozyrev.superchat.core.data.IAuthRepository;
import io.reactivex.Observable;

/**
 * Интерактор, содержащий в себе бизнес логику авторизации
 *
 * @author Kozyrev Boris
 */
public class AuthInteractor {

    private final IAuthRepository mLoginRepository;
    private final IRxSchedulers mRxSchedulers;

    public AuthInteractor(@NonNull IAuthRepository loginRepository, @NonNull IRxSchedulers rxSchedulers) {
        mLoginRepository = loginRepository;
        mRxSchedulers = rxSchedulers;
    }

    public Observable<AuthState> observeAuthState() {
        return mLoginRepository
                .observeAuthState()
                .subscribeOn(mRxSchedulers.getIOScheduler())
                .observeOn(mRxSchedulers.getMainThreadScheduler());
    }

    public void signOut() {
        mLoginRepository.signOut();
    }
}
