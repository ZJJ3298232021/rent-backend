package site.webzank.rent.pojo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author zank
 */
@Data
@Builder
public class UserInfoVo {
    private Integer id;
    private String nickname;
    private String avatar;
}
