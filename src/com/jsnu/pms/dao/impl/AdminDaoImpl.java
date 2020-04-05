package com.jsnu.pms.dao.impl;

import com.jsnu.pms.dao.IAdminDao;
import com.jsnu.pms.data.AdminNode;
import com.jsnu.pms.entity.Admin;

/**
 * @author 李广帅
 * @Date 2020/4/5 5:41 下午
 */
public class AdminDaoImpl implements IAdminDao {
    private AdminNode adminHead = null;

    public AdminDaoImpl() {

        Admin admin = new Admin("1", "admin", "admin");

        this.adminHead = new AdminNode();
        this.adminHead.setPrev(null);
        this.adminHead.setNext(null);
        this.adminHead.setData(admin);
    }


    @Override
    public Admin findAdmin(String username, String password) {
        AdminNode node = this.adminHead;
        while (node != null) {
            Admin admin = node.getData();
            if (admin.getAdminName().matches(username) && admin.getPassword().matches(password)) {
                return admin;
            }
            node = node.getNext();
        }
        return null;
    }
}
