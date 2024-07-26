package com.example.coupons.common.dataAccess

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coupons.common.entities.CouponEntity


@Dao
interface CouponDao {

    @Query("SELECT * FROM CouponEntity WHERE code = :code ")//traer esa consulta
    suspend fun consultCouponsByCode(code: String): CouponEntity?

    @Insert
    suspend fun addCoupon(coupon: CouponEntity): Long


}