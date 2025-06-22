package site.webzank.rent.pojo.vo;

import lombok.Builder;
import lombok.Data;
import site.webzank.rent.pojo.dto.TagDto;
import site.webzank.rent.pojo.entity.Activity;

import java.util.List;

/**
 * @author zank
 */
@Data
@Builder
public class HouseVo {
    private String id;
    private String housePicture;
    private List<TagDto> tags;
    private String houseTitle;
    private String address;
    private String rentPriceUnit;
    private String rentPriceListing;
    private Integer rentArea;
    private Activity activity;
}
