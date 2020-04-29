package com.jsnu.pms.data;

import com.jsnu.pms.entity.Member;

/**
 * @Author 周星晨
 * @Date 2020/4/27 22:09
 */
public class MemberNode {
    private MemberNode prev;
    private MemberNode next;
    private Member data;

    public MemberNode() {

    }

    public MemberNode(MemberNode prev, MemberNode next, Member data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public MemberNode getPrev() {
        return prev;
    }

    public void setPrev(MemberNode prev) {
        this.prev = prev;
    }

    public MemberNode getNext() {
        return next;
    }

    public void setNext(MemberNode next) {
        this.next = next;
    }

    public Member getData() {
        return data;
    }

    public void setData(Member data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MemberNode{" +
                "prev=" + prev +
                ", next=" + next +
                ", data=" + data +
                '}';
    }
}
