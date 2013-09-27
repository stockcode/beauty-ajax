package cn.nit.beauty.domain;

import cn.nit.beauty.Utils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {

    private Integer pkid;
	private String username;
	private String passwd;
    private Date regDate;
    private Date expiredDate;
    private Integer score;
    private String email;
    private String phone;

    @Id
    @GeneratedValue
    @Column(name = "pkid", unique = true, nullable = false)
    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "passwd")
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Column(name = "regdate")
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Column(name = "expireddate")
    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("pkid=").append(pkid);
        sb.append(", username='").append(username).append('\'');
        sb.append(", passwd='").append(passwd).append('\'');
        sb.append(", regDate=").append(Utils.formatDate(regDate));
        sb.append(", expiredDate=").append(Utils.formatDate(expiredDate));
        sb.append(", score=").append(score);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
