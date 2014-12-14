package cn.nit.beauty.domain;

/**
 * Created by gengke on 2014/12/13.
 */
public class Pay {
    private String userid;
    private String fee;
    private String tradeno;

    public Pay(String userid, String fee, String tradeno) {
        this.userid = userid;
        this.fee = fee;
        this.tradeno = tradeno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }
}
