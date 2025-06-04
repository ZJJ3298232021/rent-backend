package site.webzank.rent.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.google.gson.Gson;
import lombok.Data;
import site.webzank.rent.pojo.vo.HouseVo;

/**
 * 
 * @author zank
 * @TableName house_info
 */
@TableName(value ="house_info")
@Data
public class HouseInfo {
    /**
     * 
     */
    @TableId(value = "id")
    private String id;

    /**
     * 
     */
    @TableField(value = "data")
    private String data;

    /**
     * 
     */
    @TableField(value = "hdic_district_name")
    private String hdicDistrictName;

    /**
     * 
     */
    @TableField(value = "rent_price_unit_listing")
    private Integer rentPriceUnitListing;

    /**
     * 
     */
    @TableField(value = "rent_area")
    private Integer rentArea;

    /**
     * 
     */
    @TableField(value = "payment")
    private String payment;

    /**
     * 
     */
    @TableField(value = "area_code")
    private Integer areaCode;

    /**
     * 
     */
    @TableField(value = "city_code")
    private Integer cityCode;

    /**
     * 
     */
    @TableField(value = "province_code")
    private Integer provinceCode;

    public HouseVo convertToVo() {
        String data = this.data;
        Gson gson = new Gson();
        HouseData houseData = gson.fromJson(data, HouseData.class);
        return HouseVo.builder()
                .id(houseData.getId())
                .housePicture("http://192.168.137.1:6060" + houseData.getHousePicture().get(0).getPicList().get(0))
                .tags(houseData.getTags())
                .houseTitle(houseData.getHouseTitle())
                .address(houseData.getAddress())
                .rentPriceUnit(houseData.getRentPriceUnit())
                .rentPriceListing(houseData.getRentPriceUnitListing())
                .rentArea(this.rentArea)
                .activity(Math.random()  < 0.01 ?
                        Activity
                                .builder()
                                .title("小圈子")
                                .textColor("#1A6200")
                                .textBackGroundColor("#DBF2D2")
                                .text("#带你参观我的小窝")
                                .icon("http://192.168.137.1:6060/public/activity_icon.png")
                                .build()
                        : null
                ).build();
    }
}