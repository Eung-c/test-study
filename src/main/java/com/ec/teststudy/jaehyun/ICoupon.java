package com.ec.teststudy.jaehyun;

public interface ICoupon {
    public boolean isValid();

    public void setValid(final boolean valid);

    public int getDiscountPercent();

    public boolean isAppliable(Item item);

    public void doExpire();

    public String getName();
}
