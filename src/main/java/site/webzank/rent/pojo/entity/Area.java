package site.webzank.rent.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @author zank
 * @TableName area
 */
@TableName(value ="area")
@Data
public class Area {
    /**
     * 
     */
    @TableId(value = "code")
    private Integer code;

    /**
     * 
     */
    @TableField(value = "name")
    private String name;

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
}