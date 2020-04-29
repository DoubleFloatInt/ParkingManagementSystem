package com.jsnu.pms.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 李广帅
 * @date 2020/4/20 10:52 下午
 */
public class PSMUtils {
    private static String matchString = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";
    private static String matchMemberPhone = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
    private static String matchMemberPassword = "^[_0-9a-zA-Z]{6,10}$";

    public static Boolean checkLicensePlateNumber(String licensePlateNumber) {
        return licensePlateNumber.matches(matchString);
    }

    public static Boolean checkMemberPhone(String phone) {
        return phone.matches(matchMemberPhone);
    }

    public static Boolean checkMemberPassword(String password) {
        return password.matches(matchMemberPassword);
    }


    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static Integer getIndexByParkPlace(String parkPlace) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(parkPlace);
        return Integer.parseInt(m.replaceAll("").trim());
    }

    public static void main(String[] args) {
        String o = "Universe";
        System.out.println(checkMemberPassword(o));
    }

}
