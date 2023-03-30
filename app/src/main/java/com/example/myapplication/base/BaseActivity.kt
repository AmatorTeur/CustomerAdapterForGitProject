package com.example.myapplication.base

import androidx.annotation.LayoutRes
import com.example.myapplication.GitHubService
import com.omega_r.base.components.OmegaActivity
import com.omega_r.base.mvp.presenters.OmegaPresenter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class BaseActivity : OmegaActivity, BaseView {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    abstract override val presenter: OmegaPresenter<out BaseView>

    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    var retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    var service = retrofit.create(GitHubService::class.java)

}