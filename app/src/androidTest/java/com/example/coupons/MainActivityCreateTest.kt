package com.example.coupons

import android.graphics.ColorSpace.match
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.coupons.mainModule.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {

    //forma de importar recursos reutilizables, con esto se tendra acceso al mainActivity
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCouponTest() {
        val etCoupon = onView(withId(R.id.etCoupon))//acceder a la vista en tiempo real
        etCoupon.check(matches(withText("")))//verifica que(view) coincida (con el texto(""))
        etCoupon.perform(click())
        etCoupon.perform(replaceText("WELCOME_01"))

        val btnConsultar = onView(withId(R.id.btnConsult))
        btnConsultar.perform(click())

         val btnCreate= onView(withId(R.id.btnCreate))
        btnCreate.check(matches(isDisplayed())) //verificar si el componente es visible.



    }


}