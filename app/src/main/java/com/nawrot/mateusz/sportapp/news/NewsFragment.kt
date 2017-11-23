package com.nawrot.mateusz.sportapp.news

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection
import retrofit2.Retrofit
import javax.inject.Inject


class NewsFragment : Fragment() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}