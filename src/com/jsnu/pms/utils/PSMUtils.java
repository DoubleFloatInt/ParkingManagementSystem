package com.jsnu.pms.utils;

/**
 * @author 李广帅
 * @Date 2020/4/20 10:52 下午
 */
public class PSMUtils {
    private static String matchString = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$";

    public static Boolean checkLicensePlateNumber(String licensePlateNumber) {
        return licensePlateNumber.matches(matchString);
    }
}
