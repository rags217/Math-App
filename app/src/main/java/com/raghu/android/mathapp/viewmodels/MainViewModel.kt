package com.raghu.android.mathapp.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raghu.android.mathapp.R

class MainViewModel : ViewModel() {

    private var _list = ArrayList<Int>()

    val mean = MutableLiveData<String>()
    val median = MutableLiveData<String>()
    val list = MutableLiveData<String>()
    val resetArrayVisibility = MutableLiveData<Int>()

    fun newEntryAdded(input: String):Int {
        try {
            val i = input.toInt()

            if(i<1)
                return R.string.invalid_number_toast
            else if(_list.size == 10)
                return R.string.max_size_toast

            if(_list.size == 0)
                resetArrayVisibility.postValue(View.VISIBLE)

            _list.add(i)
            _list.sort()
            calculateMean()
            calculateMedian()
            getNumberArrayString()
            return -1
        } catch (ex: NumberFormatException) {
            return R.string.invalid_number_toast
        }
    }

    private fun calculateMean() {
        var listTotal = 0F
        for (i in _list)
            listTotal += i

        mean.postValue("%.1f".format(listTotal/_list.size))
    }

    private fun calculateMedian() {
        val listSize = _list.size
        var _median = 0F

        if(listSize == 1)
            _median = _list.get(0).toFloat()
        else if(listSize%2 == 0)
            _median = (_list.get(listSize/2-1).toFloat()+_list.get(listSize/2).toFloat())/2
        else
            _median = _list.get(listSize/2).toFloat()

        median.postValue("%.1f".format(_median))
    }

    private fun getNumberArrayString() {
        var numberArrayStr = "{"
        for(i in _list) {
            numberArrayStr = numberArrayStr.plus("$i,")
        }
        list.postValue(numberArrayStr.dropLast(1).plus('}'))
    }

    fun resetArray() {
        _list = ArrayList<Int>()
        list.postValue("{}")
        mean.postValue("")
        median.postValue("")
        resetArrayVisibility.postValue(View.GONE)
    }

}

