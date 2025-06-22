package site.webzank.rent.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import site.webzank.rent.pojo.entity.UserInfo;

/**
 * @author zank
 */
public class JwtUtil {
    public static final String SECRET = "zank";

    /**
     * 生成token
     *
     * @param info 用户名
     * @return token
     */
    public static String generateToken(UserInfo info) {
        return JWT.create()
                .withAudience(new Gson().toJson(info))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static String getAudience(String token) {
        return JWT.decode(token).getAudience().get(0);
    }

}