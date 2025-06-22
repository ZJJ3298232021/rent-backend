package site.webzank.rent.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.webzank.rent.common.result.PageResult;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.pojo.dto.PageSearchDto;
import site.webzank.rent.pojo.vo.HouseDetailVo;
import site.webzank.rent.pojo.vo.HouseVo;
import site.webzank.rent.service.HouseInfoService;

/**
 * @author zank
 */
@RestController
@Slf4j
@RequestMapping("/house")
@RequiredArgsConstructor
public class HouseController {
    private final Gson gson;
    private final HouseInfoService houseInfoService;

    @GetMapping("/nearbyHouses")
    public Object nearbyHouses() {
        String data = """
                {
                    "code": 200,
                    "message": "success",
                    "data": [
                        {
                            "id": "BJ1841694485952593920",
                            "housePicture": "http://192.168.216.1:6060/public/room83.jpg",
                            "tags": [
                                {
                                    "name": "官方核验"
                                },
                                {
                                    "name": "集中供暖"
                                },
                                {
                                    "name": "随时看房"
                                }
                            ],
                            "houseTitle": "整租·武夷花园牡丹园 2室2厅 南/北",
                            "address": "通州·武夷花园",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "3600",
                            "rentArea": "86.63"
                        },
                        {
                            "id": "BJ1836732325094752256",
                            "housePicture": "http://192.168.216.1:6060/public/room12.jpg",
                            "tags": [
                                {
                                    "name": "官方核验"
                                },
                                {
                                    "name": "近地铁"
                                },
                                {
                                    "name": "精装"
                                },
                                {
                                    "name": "集中供暖"
                                }
                            ],
                            "houseTitle": "整租·御景春天C区 1室1厅 东南",
                            "address": "丰台·科技园区",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "4600",
                            "rentArea": "48.00"
                        },
                        {
                            "id": "BJ1602527991374544896",
                            "housePicture": "http://192.168.216.1:6060/public/room70.jpg",
                            "tags": [
                                {
                                    "name": "月租"
                                },
                                {
                                    "name": "精装"
                                },
                                {
                                    "name": "独立阳台"
                                },
                                {
                                    "name": "集中供暖"
                                },
                                {
                                    "name": "随时看房"
                                }
                            ],
                            "houseTitle": "合租·合生国际花园 4居室 北卧",
                            "address": "朝阳·双井",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "3200",
                            "rentArea": "12.00"
                        },
                        {
                            "id": "BJ1844671495528251392",
                            "housePicture": "http://192.168.216.1:6060/public/room19.jpg",
                            "tags": [
                                {
                                    "name": "官方核验"
                                },
                                {
                                    "name": "近地铁"
                                },
                                {
                                    "name": "精装"
                                },
                                {
                                    "name": "集中供暖"
                                },
                                {
                                    "name": "随时看房"
                                }
                            ],
                            "houseTitle": "整租·育新花园 1室1厅 南/北",
                            "address": "海淀·西三旗",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "5000",
                            "rentArea": "47.30"
                        },
                        {
                            "id": "BJ1786352103019511808",
                            "housePicture": "http://192.168.216.1:6060/public/room59.jpg",
                            "tags": [
                                {
                                    "name": "近地铁"
                                },
                                {
                                    "name": "精装"
                                },
                                {
                                    "name": "集中供暖"
                                },
                                {
                                    "name": "押一付一"
                                },
                                {
                                    "name": "随时看房"
                                }
                            ],
                            "houseTitle": "整租·秀水园 1室1厅 南",
                            "address": "朝阳·甜水园",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "6490",
                            "rentArea": "52.40"
                        },
                        {
                            "id": "BJ1842778538210492416",
                            "housePicture": "http://192.168.216.1:6060/public/room76.jpg",
                            "tags": [
                                {
                                    "name": "官方核验"
                                },
                                {
                                    "name": "近地铁"
                                },
                                {
                                    "name": "集中供暖"
                                },
                                {
                                    "name": "随时看房"
                                }
                            ],
                            "houseTitle": "整租·万年花城二期 3室2厅 西南",
                            "address": "丰台·玉泉营",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "8500",
                            "rentArea": "112.22"
                        },
                        {
                            "id": "BJ1854906983803518976",
                            "housePicture": "http://192.168.216.1:6060/public/room11.jpg",
                            "tags": [
                                {
                                    "name": "新上"
                                },
                                {
                                    "name": "独立卫生间"
                                },
                                {
                                    "name": "精装"
                                },
                                {
                                    "name": "独立阳台"
                                },
                                {
                                    "name": "押一付一"
                                }
                            ],
                            "houseTitle": "合租·佰嘉城 3居室 南卧",
                            "address": "昌平·回龙观",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "4590",
                            "rentArea": "36.49"
                        },
                        {
                            "id": "BJ1852575117964476416",
                            "housePicture": "http://192.168.216.1:6060/public/room93.jpg",
                            "tags": [
                                {
                                    "name": "官方核验"
                                },
                                {
                                    "name": "业主自荐"
                                },
                                {
                                    "name": "集中供暖"
                                },
                                {
                                    "name": "随时看房"
                                }
                            ],
                            "houseTitle": "整租·地铁古城家园 1室1厅 南",
                            "address": "石景山·杨庄",
                            "rentPriceUnit": "元/月",
                            "rentPriceListing": "4300",
                            "rentArea": "62.84"
                        }
                    ]
                }
                """;
        //用Gson库转换为Json
        return gson.fromJson(data, Object.class);
    }

    @GetMapping("/search")
    public Result<PageResult<HouseVo>> search(PageSearchDto dto) {
        log.info("搜索参数：{}", dto);
        return Result.success(houseInfoService.search(dto));
    }

    @GetMapping("/detail")
    public Result<HouseDetailVo> detail(String id) {
        log.info("查看详情参数：{}", id);
        return Result.success(houseInfoService.detail(id));
    }
}
