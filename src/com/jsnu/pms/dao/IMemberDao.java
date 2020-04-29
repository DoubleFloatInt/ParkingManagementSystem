package com.jsnu.pms.dao;

import com.jsnu.pms.entity.Member;

import java.io.InputStream;
import java.util.List;

/**
 * @Author 周星晨
 * @Date 2020/4/27 22:16
 */
public interface IMemberDao {
    /*
    * 注册会员
    * */
    public void addMember(Member member);

    /*
    * 获取所有会员信息
    * */
    public List<Member> getAllMember();

    /*
    * 获取会员人数
    * */
    public Integer getMemberNum();

    /*
    * 根据手机号获取会员个人信息
    * */
    public Member getMemberInfo(String phone);

    /*
    * 查找会员
    * */
    public Member findMember(String phone,String password);

    /*
    *获取钻石会员人数
    * */
    public Integer getDiamondNum();

    /*
    * 获取铂金会员人数
    * */
    public Integer getPlatinumNum();

    /*
    * 获取黄金会员人数
    * */
    public Integer getGoldNum();
}
