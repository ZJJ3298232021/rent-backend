package site.webzank.rent.pojo.vo;

import lombok.Builder;
import lombok.Data;
import site.webzank.rent.pojo.dto.TagDto;
import site.webzank.rent.pojo.entity.DistanceInfo;

import java.util.List;

/**
 * @author zank
 */
@Data
@Builder
public class HistoryVo {
    private Integer id;
    private String date;
    private String houseId;
    private String img;
    private String title;
    private String subTitle;
    private DistanceInfo distanceInfo;
    private String rentPrice;
    private List<TagDto> tags;
    private String comment;
}
