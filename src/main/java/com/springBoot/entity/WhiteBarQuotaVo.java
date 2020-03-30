package com.springBoot.entity;

public class WhiteBarQuotaVo {
    /*
        可用额度
     */
    private Float canUse;
    /*
        已使用
     */
    private Float used;
    /*
        已结算
     */
    private Float Settled;
    /*
       未结算
    */
    private Float noSettled;

    public Float getUsed() {
        return used;
    }

    public void setUsed(Float used) {
        this.used = used;
    }

    public Float getSettled() {
        return Settled;
    }

    public void setSettled(Float settled) {
        Settled = settled;
    }

    public Float getNoSettled() {
        return noSettled;
    }

    public void setNoSettled(Float noSettled) {
        this.noSettled = noSettled;
    }

    public Float getCanUse() {
        return canUse;
    }

    public void setCanUse(Float canUse) {
        this.canUse = canUse;
    }
}
