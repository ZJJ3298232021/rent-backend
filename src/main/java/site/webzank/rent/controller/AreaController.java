package site.webzank.rent.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.pojo.entity.Area;
import site.webzank.rent.pojo.entity.City;
import site.webzank.rent.pojo.entity.Province;
import site.webzank.rent.service.AreaService;
import site.webzank.rent.service.CityService;
import site.webzank.rent.service.ProvinceService;

import java.util.List;

/**
 * @author zank
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class AreaController {
    private final ProvinceService provinceService;
    private final CityService cityService;
    private final AreaService areaService;

    @GetMapping("/province")
    public Result<List<Province>> getAllProvince() {
        return Result.success(provinceService.list());
    }

    @GetMapping("/city")
    public Result<List<City>> getCity(Integer provinceCode) {
        return Result.success(cityService.list(new LambdaQueryWrapper<>(City.class).eq(City::getProvinceCode, provinceCode)));
    }

    @GetMapping("/area")
    public Result<List<Area>> getArea(Integer cityCode) {
        return Result.success(areaService.list(new LambdaQueryWrapper<>(Area.class).eq(Area::getCityCode, cityCode)));
    }
}
