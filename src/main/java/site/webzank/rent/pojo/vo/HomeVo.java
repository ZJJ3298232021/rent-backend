package site.webzank.rent.pojo.vo;

import lombok.Data;
import site.webzank.rent.pojo.entity.*;

import java.util.List;

/**
 * @author zank
 */
@Data
public class HomeVo {
    private List<HomeBanner> bannerList;
    private List<HomeNav> navList;
    private List<HomeTitle> tileList;
    private List<HomePlan> planList;
    private String adPicture;
}
