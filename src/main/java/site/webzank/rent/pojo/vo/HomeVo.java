package site.webzank.rent.pojo.vo;

import lombok.Data;
import site.webzank.rent.pojo.entity.HomeBanner;
import site.webzank.rent.pojo.entity.HomeNav;
import site.webzank.rent.pojo.entity.HomePlan;
import site.webzank.rent.pojo.entity.HomeTitle;

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
