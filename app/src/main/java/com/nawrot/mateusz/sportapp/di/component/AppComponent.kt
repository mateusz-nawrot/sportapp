package com.nawrot.mateusz.sportapp.di.component

import com.nawrot.mateusz.sportapp.App
import com.nawrot.mateusz.sportapp.di.module.ActivityBuilderModule
import com.nawrot.mateusz.sportapp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

}