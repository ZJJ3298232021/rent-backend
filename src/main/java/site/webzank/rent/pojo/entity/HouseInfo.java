package site.webzank.rent.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
        HouseVo houseVo = new HouseVo();
        String data = this.data;

    }
}