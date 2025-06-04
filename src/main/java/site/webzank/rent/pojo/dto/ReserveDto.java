package site.webzank.rent.pojo.dto;

import lombok.Data;

/**
 * @author zank
 */
@Data
public class ReserveDto {
    private String name;
    private String date;
    private Integer houseId;
    private String phone;
    private String comment;
}
