package site.webzank.rent.pojo.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author zank
 */
@Data
@Builder
public class ReservationVo {
    private Integer id;
    private Integer userId;
    private String houseId;
    private String date;
    private String name;
    private String comment;
}
