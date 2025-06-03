package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import site.webzank.rent.pojo.entity.HouseInfo;
import site.webzank.rent.service.HouseInfoService;
import site.webzank.rent.mapper.HouseInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author zank
* @description 针对表【house_info】的数据库操作Service实现
* @createDate 2025-06-03 14:58:31
*/
@Service
public class HouseInfoServiceImpl extends ServiceImpl<HouseInfoMapper, HouseInfo>
    implements HouseInfoService{

}




