package com.example.coupons.common.utils

import com.example.coupons.R
import com.example.coupons.common.entities.CouponEntity
import org.junit.Assert.*
import org.junit.Test

class CouponUtilsKtTest {

    @Test
    fun validateTextCodeSuccessTest() {
        val code = "WELCOME"
        assertTrue(validateTextCode(code))
    }

    @Test
    fun validateTextCodeEmptyFailTest() {
        val code = ""
        assertFalse(validateTextCode(code))
    }

    @Test
    fun validateTextCodeMinLengthTest() {
        val code = "HOLA"
        val code2 = "HOLA2"
        assertFalse(validateTextCode(code))
        assertTrue(validateTextCode(code2))
    }

    @Test
    fun validateTextCodeMaxLengthTest() {
        val code = "HOLA567891"
        val code2 = "HOLA5678912"
        assertFalse(validateTextCode(code2))
        assertTrue(validateTextCode(code))
    }

    @Test
    fun getMsgErrorByCodeNullTest() {
        val errorCode = null
        val expectedValue = R.string.error_unknow
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar un null", expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeExistTest() {
        val errorCode = Constants.ERROR_EXIST
        val expectedValue = R.string.error_unique_code
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar un cupon existente", expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeLengthTest() {
        val errorCode = Constants.ERROR_LENGHT
        val expectedValue = R.string.error_invalid_lenght
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar la longitud valida de un cupon", expectedValue, result)
        assertNotEquals("El recurso no existe.", -1, result)
    }

    @Test
    fun checkNotNullCouponTest() {
        val coupon = CouponEntity(code = "Androd", description = "Curso a pocos dlls")
        assertNotNull("El cupon no deberia ser nulo.",coupon)
    }
    @Test
    fun checkNullCouponTest() {
        val coupon = null
        assertNull("El cupon deberia ser nulo.",coupon)
    }
    @Test
    fun checkGroupSuccessTest() {
        val aNames = arrayOf("Angel", "Daniel", "Mary")//valor actual
        val bNames = arrayOf("Angel", "Daniel", "Mary")//valor esperado
        assertArrayEquals("Los arreglos deberian coincidir, revise sus elementos.",bNames, aNames)
    }
    @Test
    fun checkGroupFailTest() {
        val aNames = arrayOf("Angel", "Daniel", "Mary")//valor actual
        val bNames = arrayOf("Angel", "Daniela", "Mary")//valor esperado
        assertNotEquals("Los arreglos no deberian coincidir.",bNames, aNames)
    }

}