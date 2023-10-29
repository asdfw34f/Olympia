package com.olympia.extensions

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.olympia.MainEntertainment

fun AppCompatActivity.openFragment(holderId: Int, f: Fragment) {
    supportFragmentManager.beginTransaction().replace(holderId, f).commit()
}
fun AppCompatActivity.message(text: String) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
fun Fragment.message(text: String) = Toast.makeText((activity as AppCompatActivity), text, Toast.LENGTH_SHORT).show()
fun Fragment.openFragment(holderId: Int, f: Fragment) {
    (activity as AppCompatActivity).supportFragmentManager.beginTransaction().replace(holderId, f).commit()
}
fun Fragment.toMainScreen(){
    val intent = Intent((activity as AppCompatActivity), MainEntertainment::class.java)
    startActivity(intent)
}
fun Fragment.getItemFromArray(arrayId: Int, index: Int): String{ return resources.getStringArray(arrayId)[index] }