package coder.mtk.viewmodel.viewmodel

import androidx.lifecycle.ViewModel

class CountViewMethod : ViewModel(){
    private var count : Int = 0

    fun getCount() : Int = count  //getter

    fun setCount(num : Int) : Int{  //setter
        count = num + 1
        return count
    }

}