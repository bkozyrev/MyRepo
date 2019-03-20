package com.bkozyrev.superchat.core.rx;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Реализация {@link IRxSchedulers}
 *
 * @author Козырев Борис
 */
public class RxSchedulers implements IRxSchedulers {

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Scheduler getMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public Scheduler getIOScheduler() {
        return Schedulers.io();
    }
}
