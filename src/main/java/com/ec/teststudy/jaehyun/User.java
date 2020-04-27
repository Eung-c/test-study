package com.ec.teststudy.jaehyun;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;

    private List<ICoupon> coupons = new ArrayList<>();

    public User(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getTotalCouponCount() {
        return coupons.size();
    }

    public void testAddCoupon(ICoupon iCoupon) {
        coupons.add(iCoupon);
    }

}
