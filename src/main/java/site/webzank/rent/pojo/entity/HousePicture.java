package site.webzank.rent.pojo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author zank
 */
@Data
@Builder
public class HousePicture {
    private String spaceName;
    private List<String> picList;
}
