package com.jsnu.pms.service.impl;

import com.jsnu.pms.dao.IAdminDao;
import com.jsnu.pms.entity.Admin;
import com.jsnu.pms.service.IAdminService;
import com.jsnu.pms.utils.Factory;

/**
 * @author 李广帅
 * @Date 2020/4/5 5:34 下午
 */
public class AdminServiceImpl implements IAdminService {
    private IAdminDao adminDao = null;

    public AdminServiceImpl() {
        this.adminDao = Factory.getAdminDao();
    }

    @Override
    public Boolean login(String adminName, String password) {
        Admin admin = adminDao.findAdmin(adminName, password);
        if (admin == null) {
            return false;
        } else {
            return true;
        }
    }
}
