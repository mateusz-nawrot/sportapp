package com.nawrot.mateusz.sportapp.di.module

import com.nawrot.mateusz.sportapp.di.scope.ActivityScope
import com.nawrot.mateusz.sportapp.home.HomeActivity
import com.nawrot.mateusz.sportapp.home.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class, FragmentBuilderModule::class))
    abstract fun bindHomeActivity(): HomeActivity

}