package site.webzank.rent.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author zank
 * @TableName user_info
 */
@TableName(value = "user_info")
@Data
@Builder
public class UserInfo {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "mail")
    private String mail;

    /**
     *
     */
    @TableField(value = "nickname")
    private String nickname;

    /**
     *
     */
    @TableField(value = "img")
    private String img;
}