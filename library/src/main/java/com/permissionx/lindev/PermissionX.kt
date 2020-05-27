package com.permissionx.lindev

import androidx.fragment.app.FragmentActivity

/*
 * =====================================================================================
 * Summary: 
 * Author: LinLinLin
 * Create: 2020/5/27 23:07
 * =====================================================================================
 */object PermissionX {
    private const val TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity,vararg permissions:String,callback:PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null){
            existedFragment as InvisibleFragment
        } else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)//*表示将一个数组转换成可变长度参数
    }
}