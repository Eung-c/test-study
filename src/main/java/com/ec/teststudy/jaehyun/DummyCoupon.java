package com.ec.teststudy.jaehyun;

public class DummyCoupon implements ICoupon {

    @Override
    public boolean isValid() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setValid(boolean valid) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getDiscountPercent() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isAppliable(Item item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void doExpire() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}