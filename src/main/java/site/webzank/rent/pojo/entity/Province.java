package site.webzank.rent.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @author zank
 * @TableName province
 */
@TableName(value ="province")
@Data
public class Province {
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
}