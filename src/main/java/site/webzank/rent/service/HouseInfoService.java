package site.webzank.rent.service;

import site.webzank.rent.common.result.PageResult;
import site.webzank.rent.pojo.dto.PageSearchDto;
import site.webzank.rent.pojo.entity.HouseInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import site.webzank.rent.pojo.vo.HouseDetailVo;
import site.webzank.rent.pojo.vo.HouseVo;

/**
* @author zank
* @description 针对表【house_info】的数据库操作Service
* @createDate 2025-06-03 14:58:31
*/
public interface HouseInfoService extends IService<HouseInfo> {

    PageResult<HouseVo> search(PageSearchDto dto);

    HouseDetailVo detail(String id);
}
