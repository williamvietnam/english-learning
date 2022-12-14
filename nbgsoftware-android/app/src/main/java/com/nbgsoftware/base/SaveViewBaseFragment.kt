package com.nbgsoftware.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

/**
 * Author: William Giang Nguyen | 8/7/2022
 *
 * Use for tab screen, webView, google map...
 */
abstract class SaveViewBaseFragment<
        VB : ViewBinding,
        VM : BaseViewModel>(
    @LayoutRes id: Int
) : BaseFragmentViewModel<VB, VM>(id) {

    private var mContainerView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mContainerView == null) {
            mContainerView = super.onCreateView(inflater, container, savedInstanceState)
        } else {
            val parent = mContainerView?.parent
            if (parent != null) {
                (parent as? ViewGroup)?.removeView(mContainerView)
            }
        }
        return mContainerView
    }

    override fun onDestroy() {
        mContainerView = null
        super.onDestroy()
    }

}