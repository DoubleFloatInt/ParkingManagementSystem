package com.jsnu.pms.data;

import com.jsnu.pms.entity.Admin;
import com.jsnu.pms.entity.Car;

/**
 * @author 李广帅
 * @Date 2020/4/5 5:45 下午
 */
public class AdminNode {
    private AdminNode prev;
    private AdminNode next;
    private Admin data;

    public AdminNode() {
    }

    public AdminNode(AdminNode prev, AdminNode next, Admin data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    public AdminNode getPrev() {
        return prev;
    }

    public void setPrev(AdminNode prev) {
        this.prev = prev;
    }

    public AdminNode getNext() {
        return next;
    }

    public void setNext(AdminNode next) {
        this.next = next;
    }

    public Admin getData() {
        return data;
    }

    public void setData(Admin data) {
        this.data = data;
    }
}
