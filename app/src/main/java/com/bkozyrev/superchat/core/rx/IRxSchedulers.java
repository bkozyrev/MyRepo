package com.bkozyrev.superchat.core.rx;

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;

/**
 * {@code Interface} для получения {@link Scheduler}, чтобы управлять исполнением
 *
 * @author Козырев Борис
 */
public interface IRxSchedulers {

    /**
     * Возвращает {@link Scheduler}, привязанный к главному потоку для передачи результата работы
     *
     * @return {@link Scheduler}
     */
    @NonNull
    Scheduler getMainThreadScheduler();

    /**
     * Возвращает {@link Scheduler} для работы с сетью и файлами (Io)
     *
     * @return {@link Scheduler}
     */
    @NonNull
    Scheduler getIOScheduler();
}
