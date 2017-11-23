package com.nawrot.mateusz.sportapp.di.module

import android.content.Context
import com.nawrot.mateusz.sportapp.data.base.AndroidSchedulersProvider
import com.nawrot.mateusz.sportapp.domain.base.SchedulersProvider
import com.nawrot.mateusz.sportapp.App
import com.nawrot.mateusz.sportapp.R
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(app: App): Context

    @Binds
    abstract fun bindSchedulersProvider(androidSchedulersProvider: AndroidSchedulersProvider): SchedulersProvider

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Named("baseUrl")
        fun applicationId(context: Context): String {
            return context.getString(R.string.base_url)
        }

        @JvmStatic
        @Provides
        @Singleton
        fun okHttpClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
            builder.retryOnConnectionFailure(true)

            val logInterceptor = HttpLoggingInterceptor()
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logInterceptor)
            return builder.build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun retrofit(okHttpClient: OkHttpClient, @Named("baseUrl") baseUrl: String): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()
        }

    }

}