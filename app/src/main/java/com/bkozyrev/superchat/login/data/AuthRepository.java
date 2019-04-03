package com.bkozyrev.superchat.login.data;

import android.support.annotation.NonNull;
import com.bkozyrev.superchat.core.data.AuthState;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import io.reactivex.Observable;

import java.util.List;

/**
 * Реализация {@link IAuthRepository}
 *
 * @author Kozyrev Boris
 */
public class AuthRepository implements IAuthRepository {

    private static final String GOOGLE_AUTH_PROVIDER = "google.com";

    private FirebaseAuth mFirebaseAuth;

    public AuthRepository(@NonNull FirebaseAuth firebaseAuth) {
        mFirebaseAuth = firebaseAuth;
    }

    @Override
    public Observable<AuthState> observeAuthState() {
        return Observable.create(emitter -> {
            mFirebaseAuth.addAuthStateListener(firebaseAuth -> {
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                if (user == null) {
                    if (!emitter.isDisposed()) {
                        emitter.onNext(AuthState.SIGNED_OUT);
                    }
                } else {
                    List<String> providers = user.getProviders();
                    if (providers == null) {
                        if (!emitter.isDisposed()) {
                            emitter.onNext(AuthState.SIGNED_OUT);
                        }
                    } else {
                        for (String provider: providers) {
                            if (provider.equals(GOOGLE_AUTH_PROVIDER)) {
                                if (!emitter.isDisposed()) {
                                    emitter.onNext(AuthState.SIGNED_WITH_GOOGLE);
                                }
                            }
                        }
                    }
                }
            });
        });
    }
}
