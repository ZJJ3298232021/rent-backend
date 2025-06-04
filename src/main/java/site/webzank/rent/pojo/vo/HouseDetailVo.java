package site.webzank.rent.pojo.vo;

import lombok.Data;
import site.webzank.rent.pojo.dto.TagDto;
import site.webzank.rent.pojo.entity.*;

import java.util.List;

/**
 * @author zank
 */
@Data
public class HouseDetailVo {
    private String houseTitle;
    private String address;
    private String rentPriceUnit;
    private List<HousePicture> housePicture;
    private List<TagDto> tags;
    private String rentPriceUnitListing;
    private DistanceInfo distanceInfo;
    private RentItem rentTerm;
    private List<MetaInfo> metaInfo;
    private String id;
    private String rentArea;
    private List<DisCount> discounts;
    private List<HouseholdItem> householdItem;
    private List<Support> support;
    private List<RentInfo> rentInfo;
}
