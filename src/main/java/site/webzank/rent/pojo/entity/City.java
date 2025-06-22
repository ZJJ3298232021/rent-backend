package site.webzank.rent.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zank
 * @TableName city
 */
@TableName(value = "city")
@Data
public class City {
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
    @TableField(value = "province_code")
    private Integer provinceCode;
}