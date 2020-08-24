package coder.mtk.badee

import androidx.lifecycle.ViewModel

class CountViewModel :ViewModel(){
    private var times : Int = 0
    private var sets : Int = 0

    fun getTimes () : Int =  times
    fun getSets () :Int = sets

    fun setTimes () : Int{
        times ++
        return times
    }
    fun setSets () : Int {
        sets ++
        return sets
    }

    fun resetTimes () : Int {
        times = 0
        return times
    }

    fun resetSets () : Int {
        sets = 0
        return sets
    }


}