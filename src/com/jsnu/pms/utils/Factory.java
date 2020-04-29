package com.jsnu.pms.utils;

import com.jsnu.pms.dao.IAdminDao;
import com.jsnu.pms.dao.ICarDao;
import com.jsnu.pms.dao.IMemberDao;
import com.jsnu.pms.dao.impl.AdminDaoImpl;
import com.jsnu.pms.dao.impl.CarDaoImpl;
import com.jsnu.pms.dao.impl.MemberDaoImpl;
import com.jsnu.pms.service.impl.AdminServiceImpl;

/**
 * @author 李广帅
 * @Date 2020/4/5 4:21 下午
 */
public class Factory {
    private static ICarDao carDao = null;
    private static IAdminDao adminDao = null;
    private static IMemberDao memberDao = null;

    public static ICarDao getCarDao() {
        if (carDao == null) {
            carDao = new CarDaoImpl();
        }
        return carDao;
    }

    public static IAdminDao getAdminDao() {
        if (adminDao == null) {
            adminDao = new AdminDaoImpl();
        }
        return adminDao;
    }

    public static IMemberDao getMemberDao() {
        if(memberDao == null){
            memberDao = new MemberDaoImpl();
        }
        return memberDao;
    }
}
