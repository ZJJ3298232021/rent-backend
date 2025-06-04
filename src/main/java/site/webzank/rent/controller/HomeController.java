package site.webzank.rent.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.pojo.vo.HomeVo;
import site.webzank.rent.service.*;

/**
 * @author zank
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    private final HomeAdService homeAdService;
    private final HomeBannerService homeBannerService;
    private final HomeTitleService homeTitleService;
    private final HomePlanService homePlanService;
    private final HomeNavService homeNavService;

    @GetMapping("/home/info")
    public Result<HomeVo> getHomeInfo() {
        log.info("获取首页信息");
        HomeVo homeVo = new HomeVo();
        homeVo.setAdPicture("http://192.168.137.1:6060"+homeAdService.list().get(0).getImageUrl());
        homeVo.setBannerList(homeBannerService.list().stream().peek(homeBanner -> homeBanner.setImageURL("http://192.168.137.1:6060" + homeBanner.getImageURL())).toList());
        homeVo.setTileList(homeTitleService.list().stream().peek(homeTitle -> homeTitle.setImageURL("http://192.168.137.1:6060" + homeTitle.getImageURL())).toList());
        homeVo.setPlanList(homePlanService.list().stream().peek(homePlan -> homePlan.setImageURL("http://192.168.137.1:6060" + homePlan.getImageURL())).toList());
        homeVo.setNavList(homeNavService.list().stream().peek(homeNav -> homeNav.setImageURL("http://192.168.137.1:6060" + homeNav.getImageURL())).toList());
        return Result.success(homeVo);
    }
}
