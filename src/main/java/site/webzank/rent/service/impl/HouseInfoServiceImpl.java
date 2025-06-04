package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.webzank.rent.common.result.PageResult;
import site.webzank.rent.mapper.HouseDetailMapper;
import site.webzank.rent.mapper.HouseInfoMapper;
import site.webzank.rent.pojo.dto.PageSearchDto;
import site.webzank.rent.pojo.entity.*;
import site.webzank.rent.pojo.vo.HouseDetailVo;
import site.webzank.rent.pojo.vo.HouseVo;
import site.webzank.rent.service.HouseInfoService;

import java.util.List;
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
    private final HouseDetailMapper houseDetailMapper;
    private final Gson gson;

    @Override
    public PageResult<HouseVo> search(PageSearchDto dto) {
        LambdaQueryWrapper<HouseInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(dto.getProvinceCode() != null, HouseInfo::getProvinceCode, dto.getProvinceCode());
        queryWrapper.eq(dto.getCityCode() != null, HouseInfo::getCityCode, dto.getCityCode());
        queryWrapper.eq(dto.getDistrictCode() != null, HouseInfo::getAreaCode, dto.getDistrictCode());
        queryWrapper.ge(dto.getMinRent() != null, HouseInfo::getRentPriceUnitListing, dto.getMinRent());
        queryWrapper.le(dto.getMaxRent() != null, HouseInfo::getRentPriceUnitListing, dto.getMaxRent());
//        queryWrapper.eq()
        queryWrapper.eq(dto.getPaymentType() != null && !dto.getPaymentType().isBlank(), HouseInfo::getPayment, dto.getPaymentType());
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
        Page<HouseInfo> page = new Page<>(dto.getPage(), dto.getLimit());
        IPage<HouseInfo> pages = houseInfoMapper.selectPage(page, queryWrapper);
        List<HouseVo> vos = pages.getRecords().stream().map(HouseInfo::convertToVo).toList();
        return new PageResult<>((int) pages.getTotal(), vos);
    }

    @Override
    public HouseDetailVo detail(String id) {
        HouseDetail houseDetail = houseDetailMapper.selectById(id);
        HouseDetailVo houseDetailVo = gson.fromJson(houseDetail.getData(), HouseDetailVo.class);
        //处理HousePic地址
        List<HousePicture> pictures = houseDetailVo
                .getHousePicture()
                .stream()
                .peek(housePicture -> housePicture.setPicList(housePicture
                        .getPicList()
                        .stream()
                        .map(pic -> pic.replace("localhost", "192.168.137.1"))
                        .toList()
                )).toList();
        houseDetailVo.setHousePicture(pictures);
        //处理Discount
        List<DisCount> disCounts = houseDetailVo
                .getDiscounts()
                .stream()
                .peek(discount ->
                        discount
                                .setImage(discount.getImage()
                                        .replace("localhost", "192.168.137.1")))
                .toList();
        houseDetailVo.setDiscounts(disCounts);
        //处理HouseholdItem
        List<HouseholdItem> householdItems = houseDetailVo
                .getHouseholdItem()
                .stream()
                .peek(householdItem -> {
                            List<Item> items = householdItem.getItemList().stream().peek(item -> item.setIcon(item.getIcon().replace("localhost", "192.168.137.1"))
                            ).toList();
                            householdItem.setItemList(items);
                        }
                ).toList();
        houseDetailVo.setHouseholdItem(householdItems);
        //处理Support
        List<Support> supports = houseDetailVo
                .getSupport()
                .stream()
                .peek(support -> support
                        .setImage(
                                support
                                        .getImage()
                                        .replace("localhost", "192.168.137.1")
                        )
                )
                .toList();
        houseDetailVo.setSupport(supports);
        //处理RentInfo
        List<RentInfo> rentInfos = houseDetailVo.getRentInfo().stream().peek(rentInfo -> rentInfo.setImage(
                rentInfo
                        .getImage()
                        .replace("localhost", "192.168.137.1")
        )).toList();
        houseDetailVo.setRentInfo(rentInfos);
        return houseDetailVo;
    }
}




