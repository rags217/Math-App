package com.raghu.android.mathapp.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.raghu.android.mathapp.R
import com.raghu.android.mathapp.databinding.ActivityMainBinding
import com.raghu.android.mathapp.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel: MainViewModel by inject()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        add_number_bt.setOnClickListener(this)
        reset_array_bt.setOnClickListener(this)

        viewModel.list.postValue("{}")
        viewModel.resetArrayVisibility.postValue(View.GONE)
    }

    override fun onClick(v: View?) {
        when(v) {
            add_number_bt -> {
                val toastID = viewModel.newEntryAdded(number_et.text.toString())
                if(toastID != -1)
                    Toast.makeText(this, toastID, Toast.LENGTH_SHORT).show()
                number_et.setText("")
            }
            reset_array_bt -> viewModel.resetArray()
        }
    }
}
