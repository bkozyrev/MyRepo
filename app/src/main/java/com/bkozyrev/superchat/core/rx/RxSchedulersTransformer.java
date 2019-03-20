package com.bkozyrev.superchat.core.rx;

import android.support.annotation.NonNull;
import io.reactivex.*;

/**
 * Реализация {@link IRxSchedulersTransformer}
 *
 * @author Козырев Борис
 */
public class RxSchedulersTransformer implements IRxSchedulersTransformer {

    private IRxSchedulers mRxSchedulers;

    public RxSchedulersTransformer(@NonNull IRxSchedulers rxSchedulers) {
        mRxSchedulers = rxSchedulers;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    @NonNull
    public <T> ObservableTransformer<T, T> getIOToMainTransformerObservable() {
        return (ObservableTransformer) observable -> observable.subscribeOn(mRxSchedulers.getIOScheduler())
                .observeOn(mRxSchedulers.getMainThreadScheduler());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    @NonNull
    public <T> SingleTransformer<T, T> getIOToMainTransformerSingle() {
        return (SingleTransformer) single -> single.subscribeOn(mRxSchedulers.getIOScheduler())
                .observeOn(mRxSchedulers.getMainThreadScheduler());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    @NonNull
    public <T> MaybeTransformer<T, T> getIOToMainTransformerMaybe() {
        return (MaybeTransformer) maybe -> maybe.subscribeOn(mRxSchedulers.getIOScheduler())
                .observeOn(mRxSchedulers.getMainThreadScheduler());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public CompletableTransformer getIOToMainTransformerCompletable() {
        return completable -> completable.subscribeOn(mRxSchedulers.getIOScheduler())
                .observeOn(mRxSchedulers.getMainThreadScheduler());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public <T> FlowableTransformer<T, T> getIOToMainTransformerFlowable() {
        return flowable -> flowable.subscribeOn(mRxSchedulers.getIOScheduler())
                .observeOn(mRxSchedulers.getMainThreadScheduler());
    }
}
