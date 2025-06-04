package site.webzank.rent.pojo.dto;

import lombok.Data;

/**
 * @author zank
 */
@Data
public class PageSearchDto {
    private Integer page;
    private Integer limit;
    private Integer provinceCode;
    private Integer cityCode;
    private Integer districtCode;
    private Integer minRent;
    private Integer maxRent;
    private String paymentType;
    private String orderBy;
    private String orderType;
}
