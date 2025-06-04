package site.webzank.rent.pojo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author zank
 */
@Data
@Builder
public class LoginVo {
    private String token;
}
