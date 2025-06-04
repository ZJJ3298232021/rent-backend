package site.webzank.rent.common.util;


import site.webzank.rent.pojo.entity.UserInfo;

/**
 * 基于ThreadLocal封装工具类，用于保存和获取当前登录用户id
 * @author zank
 */
public class ThreadLocalUtil {

    public static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public static UserInfo getCurrentInfo() {
        return threadLocal.get();
    }

    public static void setCurrentInfo(UserInfo info) {
        threadLocal.set(info);
    }

    public static void removeCurrentInfo() {
        threadLocal.remove();
    }

}
