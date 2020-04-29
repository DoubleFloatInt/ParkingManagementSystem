package com.jsnu.pms.entity;

/**
 * @Author 周星晨
 * @Date 2020/4/27 21:53
 */
public class Member {
    /*
    * 会员卡号
    * */
    private String id;

    /*
    * 会员名
    * */
    private String memberName;

    /*
    * 会员密码
    * */
    private String memberPassword;

    /*
    * 会员手机号
    * */
    private String membePhone;

    /*
    * 会员等级
    * */
    private String memberLevel;

    /*
    * 余额
    * */
    private Double money;

    public Member() {
    }

    public Member(String id, String memberName, String memberPassword, String membePhone, String memberLevel, Double money) {
        this.id = id;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.membePhone = membePhone;
        this.memberLevel = memberLevel;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMembePhone() {
        return membePhone;
    }

    public void setMembePhone(String membePhone) {
        this.membePhone = membePhone;
    }

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", membePhone='" + membePhone + '\'' +
                ", memberLevel='" + memberLevel + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
