package site.webzank.rent.pojo.vo;

import lombok.Data;
import site.webzank.rent.pojo.entity.Activity;
import site.webzank.rent.pojo.entity.HouseTag;

import java.util.List;

/**
 * @author zank
 */
@Data
public class HouseVo {
    private String id;
    private String housePicture;
    private List<HouseTag> tags;
    private String houseTitle;
    private String address;
    private String rentPriceUnit;
    private int rentPriceListing;
    private String rentArea;
    private Activity activity;
}
