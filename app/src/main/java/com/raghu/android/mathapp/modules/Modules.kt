package com.raghu.android.mathapp.modules

import com.raghu.android.mathapp.viewmodels.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { MainViewModel() }
}