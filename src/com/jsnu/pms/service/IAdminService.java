package com.jsnu.pms.service;

/**
 * @author 李广帅
 * @Date 2020/4/4 4:47 下午
 */
public interface IAdminService {
    /**
     * 管理员登录
     * @param adminName 管理员账号
     * @param password 管理员密码
     * @return
     */
    public Boolean login(String adminName, String password);
}
