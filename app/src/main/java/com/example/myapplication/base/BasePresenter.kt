package com.example.myapplication.base

import com.example.myapplication.R
import com.omega_r.base.mvp.presenters.OmegaPresenter
import com.omega_r.libs.omegatypes.Text

open class BasePresenter <V: BaseView>() : OmegaPresenter<V>(){

    protected fun messageComingSoon(){
        viewState.showToast(Text.from(R.string.message_coming_soon))
    }
}