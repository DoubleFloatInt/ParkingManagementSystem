package com.jsnu.pms.dao;

import com.jsnu.pms.entity.Admin;

/**
 * @author 李广帅
 * @Date 2020/4/5 5:37 下午
 */
public interface IAdminDao {
    /**
     * 查找管理员
     * @param username
     * @param password
     * @return
     */
    public Admin findAdmin(String username, String password);
}
