package site.webzank.rent.interceptor;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.common.util.JwtUtil;
import site.webzank.rent.common.util.ThreadLocalUtil;
import site.webzank.rent.pojo.entity.UserInfo;

/**
 * @author zank
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    private final Gson gson;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        //1、从请求头中获取令牌
        String token = request.getHeader("token");

        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);
            UserInfo userInfo = gson.fromJson(JwtUtil.getAudience(token), UserInfo.class);
            log.info("当前用户id：{}", userInfo.getId());
            //保存当前登录用户的信息
            ThreadLocalUtil.setCurrentInfo(userInfo);
            //3、通过，放行
            return true;
        } catch (Exception ex) {
            //4、不通过，响应状态码401
            response.setStatus(401);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(gson.toJson(Result.error("未登录")));
            return false;
        }
    }
}
