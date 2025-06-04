package site.webzank.rent.pojo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import site.webzank.rent.pojo.dto.TagDto;

import java.util.List;

@Data
public class HouseData {
    private String houseTitle;
    private String address;
    private String rentPriceUnit;
    private List<HousePicture> housePicture;
    private List<TagDto> tags;
    private String rentPriceUnitListing;
    @JsonProperty("distance_info")
    private DistanceInfo distanceInfo;
    private RentItem rentItem;
    private List<MetaInfo> metaInfo;
    private Integer id;
}
