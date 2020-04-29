package com.jsnu.pms.dao.impl;

import com.jsnu.pms.dao.IMemberDao;
import com.jsnu.pms.data.AdminNode;
import com.jsnu.pms.data.MemberNode;
import com.jsnu.pms.entity.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 周星晨
 * @Date 2020/4/27 22:37
 */
public class MemberDaoImpl implements IMemberDao {
    private MemberNode memberHead = new MemberNode();

    private final Integer diamondNum = 0;
    private final Integer platinumNum =0;
    private final Integer goldNum = 0;

    public MemberDaoImpl() {
        init();
    }

    public void init(){
        Member member = new Member("1", "Universe", "zxc98_", "15862175346", "黄金会员",100.00);
        addMember(member);
    }




    @Override
    public void addMember(Member member) {
        MemberNode node = this.memberHead;
        while(node.getNext() != null){
            node = node.getNext();
        }
        MemberNode newNode = new MemberNode();
        newNode.setData(member);
        newNode.setPrev(node);
        newNode.setNext(null);
        node.setNext(newNode);
    }


    @Override
    public List<Member> getAllMember() {
        List<Member> memberList = new ArrayList<>();
        MemberNode node = this.memberHead.getNext();
        while (node != null){
            memberList.add(node.getData());
            node = node.getNext();
        }
        return memberList;
    }

    @Override
    public Integer getMemberNum() {
        Integer memberNum = 0;
        MemberNode node = this.memberHead.getNext();
        while (node != null){
            memberNum ++;
            node = node.getNext();
        }
        return memberNum;
    }

    @Override
    public Member getMemberInfo(String phone) {
        MemberNode node = this.memberHead.getNext();
        while(node != null){
            Member member = node.getData();
            if(member.getMembePhone() == phone){
                return member;
            }
            else{
                node = node.getNext();
            }
        }
        return null;
    }

    @Override
    public Member findMember(String phone, String password) {
        MemberNode node = this.memberHead.getNext();
        while(node != null){
            Member member = node.getData();

            if(member.getMembePhone().equals(phone) && member.getMemberPassword().equals(password)){
                return member;
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public Integer getDiamondNum() {
        Integer diamondNum = 0;
        MemberNode node = this.memberHead.getNext();
        while(node != null){
            Member member = node.getData();
            if(member.getMemberLevel() == "钻石会员"){
                diamondNum ++;
            }
            else{
                node = node.getNext();
            }
        }
        return diamondNum;

    }

    @Override
    public Integer getPlatinumNum() {
        Integer platinumNum = 0;
        MemberNode node = this.memberHead.getNext();
        while(node != null){
            Member member = node.getData();
            if(member.getMemberLevel() == "铂金会员"){
                platinumNum ++;
            }
            else{
                node = node.getNext();
            }
        }
        return platinumNum;
    }

    @Override
    public Integer getGoldNum() {
        Integer goldNum = 0;
        MemberNode node = this.memberHead.getNext();
        while(node != null){
            Member member = node.getData();
            if(member.getMemberLevel() == "黄金会员"){
                goldNum ++;
            }
            else{
                node = node.getNext();
            }
        }
        return goldNum;
    }

    public static void main(String[] args) {

    }


}
