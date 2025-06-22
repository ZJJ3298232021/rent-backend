package site.webzank.rent.controller;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zank
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class ServiceController {
    private final Gson gson;

    @GetMapping("/service/info")
    public Object service() {
        String data = """
                {
                    "code": 200,
                    "message": "success",
                    "data": {
                        "vipServiceList": [
                            {
                                "name": "余额",
                                "content": 0
                            },
                            {
                                "name": "优惠券",
                                "content": 4
                            },
                            {
                                "name": "会员特权",
                                "content": 7
                            },
                            {
                                "name": "会员福利",
                                "content": 21
                            }
                        ],
                        "homeServiceList": [
                            {
                                "icon": "http://192.168.216.1:6060/public/service01.png",
                                "title": "省心搬家"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service02.png",
                                "title": "日常保洁"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service03.png",
                                "title": "新人专区"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service04.png",
                                "title": "家电清洗"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service05.png",
                                "title": "维修安装"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service06.png",
                                "title": "一站搬家"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service07.png",
                                "title": "深度保洁"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service08.png",
                                "title": "空调清洗"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service09.png",
                                "title": "包年初体验"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service10.png",
                                "title": "家庭保姆"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service11.png",
                                "title": "上门喂猫"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service12.png",
                                "title": "新居开荒"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service13.png",
                                "title": "精细擦窗"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service14.png",
                                "title": "洗衣机清洗"
                            },
                            {
                                "icon": "http://192.168.216.1:6060/public/service15.png",
                                "title": "更多"
                            }
                        ],
                        "serviceActivity": {
                            "name": "12.9-12.19 限享6大礼包",
                            "img": "http://192.168.216.1:6060/public/ServiceActivityImg.png",
                            "title": "包年服务好礼享不停",
                            "subTitle": "最高领¥300优惠券"
                        },
                        "newcomerZone": {
                            "img": "http://192.168.216.1:6060/public/newcommerImg.jpg"
                        },
                        "cleaningServiceInfo": [
                            {
                                "img": "http://192.168.216.1:6060/public/cleaningServiceImg01.jpg",
                                "title": "日常保洁2小时",
                                "subTitle": "推荐60m²以内的房屋",
                                "originalPrice": "119",
                                "priceAfterDiscounts": "80"
                            },
                            {
                                "img": "http://192.168.216.1:6060/public/cleaningServiceImg02.jpg",
                                "title": "日常保洁3小时",
                                "subTitle": "推荐80m²以内的房屋",
                                "originalPrice": "135",
                                "priceAfterDiscounts": "119"
                            }
                        ]
                    }
                }
                """;

        return gson.fromJson(data, Object.class);
    }

    @GetMapping("/discover/info")
    public Object discover() {
        String data = """
                
                {
                    "code": 200,
                    "message": "success",
                    "data": {
                        "danMuList1": [
                            {
                                "avatar": "http://192.168.216.1:6060/public/add_button.png",
                                "content": "分享你此刻"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user01.png",
                                "content": "干饭了"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user03.png",
                                "content": "过生日"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user05.png",
                                "content": "真开心"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user07.png",
                                "content": "哈哈哈"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user09.png",
                                "content": "看电影"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user01.png",
                                "content": "画画创作"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user02.png",
                                "content": "打篮球"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user03.png",
                                "content": "听音乐"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user04.png",
                                "content": "写日记"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user05.png",
                                "content": "学习新语言"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user06.png",
                                "content": "烤蛋糕"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user07.png",
                                "content": "拍摄短片"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user08.png",
                                "content": "做手工艺"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user09.png",
                                "content": "观赏花园"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user10.png",
                                "content": "爬山"
                            }
                        ],
                        "danMuList2": [
                            {
                                "avatar": "http://192.168.216.1:6060/public/user02.png",
                                "content": "晒太阳"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user04.png",
                                "content": "好朋友聚会"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user06.png",
                                "content": "哇塞！"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user08.png",
                                "content": "逛街购物"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user10.png",
                                "content": "逛街购物"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user09.png",
                                "content": "看电影"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user08.png",
                                "content": "喝咖啡"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user03.png",
                                "content": "游泳健身"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user01.png",
                                "content": "烹饪美食"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user02.png",
                                "content": "阅读书籍"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user03.png",
                                "content": "音乐会"
                            },
                            {
                                "avatar": "http://192.168.216.1:6060/public/user04.png",
                                "content": "瑜伽课"
                            }
                        ],
                        "postZone": {
                            "mainPost": {
                                "followerNum": 4998,
                                "title": "出闲置🔍",
                                "userAvatar": "http://192.168.216.1:6060/public/user11.png",
                                "userName": "打摩的",
                                "postContent": "整租一套房子，两室一厅，一厨一卫。95平，南北通透，落地窗。家具家电齐全，领包入住，希望是女生。此外，该房源位于便利的社区，周围环境安静优雅，有完善的安全系统。小区内设施完善，包括健身房、游泳池以及儿童游乐区。"
                            },
                            "contentBlockList": [
                                {
                                    "img": "http://192.168.216.1:6060/public/block01.png"
                                },
                                {
                                    "img": "http://192.168.216.1:6060/public/block02.png"
                                },
                                {
                                    "img": "http://192.168.216.1:6060/public/block03.png"
                                }
                            ]
                        },
                        "benefits": [
                            {
                                "title": "咕咕请你看电影",
                                "img": "http://192.168.216.1:6060/public/benefits.png"
                            },
                            {
                                "title": "咕咕请你看电影",
                                "img": "http://192.168.216.1:6060/public/benefits.png"
                            }
                        ]
                    }
                }
                """;
        return gson.fromJson(data, Object.class);
    }
}
