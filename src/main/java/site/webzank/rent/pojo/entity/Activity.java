package site.webzank.rent.pojo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author zank
 */
@Data
@Builder
public class Activity {
    private String title;
    private String textColor;
    private String textBackGroundColor;
    @JsonProperty("#text")
    private String text;
    private String icon;
}
