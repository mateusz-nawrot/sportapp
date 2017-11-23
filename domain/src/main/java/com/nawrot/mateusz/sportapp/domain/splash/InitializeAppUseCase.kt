package com.nawrot.mateusz.sportapp.domain.splash.interactor

import com.nawrot.mateusz.sportapp.domain.base.SchedulersProvider
import com.nawrot.mateusz.sportapp.domain.base.usecase.CompletableUseCase
import io.reactivex.Completable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class InitializeAppUseCase @Inject constructor(schedulersProvider: SchedulersProvider) : CompletableUseCase<String>(schedulersProvider) {

    //dummy implementation
    override fun createUseCaseCompletable(param: String): Completable {
        return Completable.create { emitter -> emitter.onComplete() }.delay(2, TimeUnit.SECONDS)
    }
}