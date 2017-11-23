package com.nawrot.mateusz.sportapp.di.module

import com.nawrot.mateusz.sportapp.di.scope.FragmentScope
import com.nawrot.mateusz.sportapp.news.NewsFragment
import com.nawrot.mateusz.sportapp.news.NewsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(NewsFragmentModule::class))
    abstract fun bindNewsFragment(): NewsFragment
}