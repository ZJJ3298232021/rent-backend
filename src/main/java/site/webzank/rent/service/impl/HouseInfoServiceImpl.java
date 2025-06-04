package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.webzank.rent.common.result.PageResult;
import site.webzank.rent.mapper.HouseInfoMapper;
import site.webzank.rent.pojo.dto.PageSearchDto;
import site.webzank.rent.pojo.entity.HouseInfo;
import site.webzank.rent.pojo.vo.HouseVo;
import site.webzank.rent.service.HouseInfoService;

import java.util.Optional;

/**
 * @author zank
 * @description 针对表【house_info】的数据库操作Service实现
 * @createDate 2025-06-03 14:58:31
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class HouseInfoServiceImpl extends ServiceImpl<HouseInfoMapper, HouseInfo>
        implements HouseInfoService {
    private final HouseInfoMapper houseInfoMapper;

    @Override
    public PageResult<HouseVo> search(PageSearchDto dto) {
        LambdaQueryWrapper<HouseInfo> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(dto.getProvinceCode() != null, HouseInfo::getProvinceCode, dto.getProvinceCode());
//        queryWrapper.eq(dto.getCityCode() != null, HouseInfo::getCityCode, dto.getCityCode());
//        queryWrapper.eq(dto.getDistrictCode() != null, HouseInfo::getAreaCode, dto.getDistrictCode());
        queryWrapper.ge(dto.getMinRent() != null, HouseInfo::getRentPriceUnitListing, dto.getMinRent());
        queryWrapper.le(dto.getMaxRent() != null, HouseInfo::getRentPriceUnitListing, dto.getMaxRent());
//        queryWrapper.eq()
        Optional.ofNullable(dto.getOrderBy()).ifPresent(orderBy -> {
            if ("price".equals(orderBy)) {
                Optional.ofNullable(dto.getOrderType()).ifPresent(type -> {
                    if ("desc".equals(type)) {
                        queryWrapper.orderByDesc(HouseInfo::getRentPriceUnitListing);
                    } else {
                        queryWrapper.orderByAsc(HouseInfo::getRentPriceUnitListing);
                    }
                });
            } else {
                Optional.ofNullable(dto.getOrderType()).ifPresent(type -> {
                    if ("desc".equals(type)) {
                        queryWrapper.orderByDesc(HouseInfo::getRentArea);
                    } else {
                        queryWrapper.orderByAsc(HouseInfo::getRentArea);
                    }
                });
            }
        });
        queryWrapper.select(HouseInfo::getData);
        Page<HouseInfo> page = new Page<>(dto.getPage(), dto.getLimit());
        IPage<HouseInfo> pages = houseInfoMapper.selectPage(page, queryWrapper);
        pages.getRecords().stream().map(HouseInfo::)
        return new PageResult<>();

    }
}




