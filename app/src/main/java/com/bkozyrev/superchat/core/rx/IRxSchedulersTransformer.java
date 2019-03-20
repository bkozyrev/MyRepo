package com.bkozyrev.superchat.core.rx;

import android.support.annotation.NonNull;
import io.reactivex.*;

/**
 * {@code Interface} для получения трансофрмеров для шедулинга потоков выполнения.
 * Использовать при помощи {@code .compose}
 *
 * @author Козырев Борис
 */

public interface IRxSchedulersTransformer {

    /**
     * Трансформер для Observable, переключает IO на main
     *
     * @param <T> тип внутри Observable
     * @return {@link ObservableTransformer}
     */
    @NonNull
    <T> ObservableTransformer getIOToMainTransformerObservable();

    /**
     * Трансформер для Single, переключает c IO на main
     *
     * @param <T> тип внутри Single
     * @return {@link SingleTransformer}
     */
    @NonNull
    <T> SingleTransformer<T, T> getIOToMainTransformerSingle();

    /**
     * Трансформер для Maybe, переключает c IO на main
     *
     * @param <T> тип внутри Maybe
     * @return {@link MaybeTransformer}
     */
    @NonNull
    <T> MaybeTransformer<T, T> getIOToMainTransformerMaybe();

    /**
     * Трансформер для Completable, переключает c IO на main
     *
     * @return {@link CompletableTransformer}
     */
    @NonNull
    CompletableTransformer getIOToMainTransformerCompletable();

    /**
     * Трансформер для Flowable, переключает c IO на main
     *
     * @param <T> тип внутри Flowable
     * @return {@link FlowableTransformer}
     */
    @NonNull
    <T> FlowableTransformer<T, T> getIOToMainTransformerFlowable();
}
