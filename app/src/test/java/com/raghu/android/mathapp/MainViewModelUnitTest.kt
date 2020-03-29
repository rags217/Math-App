package com.raghu.android.mathapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.raghu.android.mathapp.viewmodels.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    val mainViewModel: MainViewModel = MainViewModel()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Test
    fun sampleCalculation1() {

        mainViewModel.newEntryAdded("2")
        mainViewModel.newEntryAdded("4")
        mainViewModel.newEntryAdded("6")

        assertEquals(mainViewModel.median.value, "4.0")
        assertEquals(mainViewModel.mean.value, "4.0")
    }

    @Test
    fun sampleCalculation2() {

        mainViewModel.newEntryAdded("2")
        mainViewModel.newEntryAdded("4")
        mainViewModel.newEntryAdded("6")
        mainViewModel.newEntryAdded("8")

        assertEquals(mainViewModel.median.value, "5.0")
        assertEquals(mainViewModel.mean.value, "5.0")
    }

    @Test
    fun sampleCalculation3() {

        mainViewModel.newEntryAdded("23")
        mainViewModel.newEntryAdded("37")
        mainViewModel.newEntryAdded("42")
        mainViewModel.newEntryAdded("55")
        mainViewModel.newEntryAdded("60")
        mainViewModel.newEntryAdded("72")
        mainViewModel.newEntryAdded("83")
        mainViewModel.newEntryAdded("91")

        assertEquals(mainViewModel.median.value, "57.5")
        assertEquals(mainViewModel.mean.value, "57.9")
    }
}
