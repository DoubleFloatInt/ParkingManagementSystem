package com.jsnu.pms.service.impl;

import com.jsnu.pms.dao.IAdminDao;
import com.jsnu.pms.dao.IMemberDao;
import com.jsnu.pms.entity.Member;
import com.jsnu.pms.service.IMemberService;
import com.jsnu.pms.utils.Factory;

import java.util.List;

/**
 * @Author 周星晨
 * @Date 2020/4/27 23:49
 */
public class MemberServiceImpl implements IMemberService {
    private IMemberDao memberDao = null;

    public MemberServiceImpl() {
        this.memberDao = Factory.getMemberDao();
    }

    @Override
    public Boolean MemberLogin(String phone,String password) {
        Member member = memberDao.findMember(phone,password);
        if(member == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Member findMember(String phone, String password) {
        return memberDao.findMember(phone,password);
    }

    @Override
    public void addMember(Member member) {

        member.setMoney(0.00);
        memberDao.addMember(member);
    }

    @Override
    public List<Member> getAllMember() {

        return memberDao.getAllMember();
    }

    @Override
    public Integer getMemberNum() {
        return memberDao.getMemberNum();
    }

    @Override
    public Member getMemberInfo(String phone) {
        return memberDao.getMemberInfo(phone);
    }

    @Override
    public Integer getDiamondNum()
    {
        return memberDao.getDiamondNum();

    }

    @Override
    public Integer getPlatinumNum() {
        return memberDao.getPlatinumNum();
    }

    @Override
    public Integer getGoldNum() {
        return memberDao.getGoldNum();
    }
}
