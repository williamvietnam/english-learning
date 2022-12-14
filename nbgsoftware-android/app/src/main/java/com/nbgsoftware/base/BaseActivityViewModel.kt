package com.nbgsoftware.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
abstract class BaseActivityViewModel<VB : ViewBinding, VM : BaseViewModel> :
    BaseActivity<VB>() {

    private lateinit var viewModel: VM

    abstract fun getVM(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getVM()
    }
}