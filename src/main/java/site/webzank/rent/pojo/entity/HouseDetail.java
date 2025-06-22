package site.webzank.rent.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zank
 * @TableName house_detail
 */
@TableName(value = "house_detail")
@Data
public class HouseDetail {
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
}