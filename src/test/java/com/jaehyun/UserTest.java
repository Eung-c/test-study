package com.jaehyun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ec.teststudy.jaehyun.DummyCoupon;
import com.ec.teststudy.jaehyun.ICoupon;
import com.ec.teststudy.jaehyun.User;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void createUser() {
        final User user = new User("jaehyun");

        assertNotNull(user);
    }

    @Test
    public void testGetName() {

        // given
        final User user = new User("jaehyun");
        final String expected = "jaehyun";

        final User user2 = new User("jaehyun2");
        final String expected2 = "jaehyun2";

        // when
        final String actual = user.getName();
        final String actual2 = user2.getName();
        // then
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testAddCoupon() {
        User user = new User("jaehyun");

        assertEquals(0, user.getTotalCouponCount(), "쿠폰 수령 전 ");

        ICoupon coupon = new DummyCoupon();

        user.testAddCoupon(coupon);

        assertEquals(1, user.getTotalCouponCount(), "쿠폰 수령 후");

    }
}