package com.nbgsoftware.ui.container

import androidx.lifecycle.ViewModelProvider
import com.nbgsoftware.base.BaseActivityViewModel
import com.nbgsoftware.databinding.ActivityContainerBinding

class ContainerActivity : BaseActivityViewModel<ActivityContainerBinding, ContainerViewModel>() {

    override fun createViewBinding(): ActivityContainerBinding {
        return ActivityContainerBinding.inflate(layoutInflater)
    }

    override fun createViewModel(): ContainerViewModel {
        return ViewModelProvider(this)[ContainerViewModel::class.java]
    }

}