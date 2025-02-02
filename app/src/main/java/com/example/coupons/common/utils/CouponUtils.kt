package com.example.coupons.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.coupons.R


fun validateTextCode(code: String): Boolean {
    return !(code.length < 5 || code.length > 10)
}

fun getMsgErrorByCode(errorCode: String?): Int = when (errorCode) {
    Constants.ERROR_EXIST -> R.string.error_unique_code
    Constants.ERROR_LENGHT -> R.string.error_invalid_lenght
    else -> R.string.error_unknow
}

fun hideKeyboard(context: Context, view: View) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}