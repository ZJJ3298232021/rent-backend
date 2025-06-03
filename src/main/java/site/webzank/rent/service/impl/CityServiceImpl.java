package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import site.webzank.rent.pojo.entity.City;
import site.webzank.rent.service.CityService;
import site.webzank.rent.mapper.CityMapper;
import org.springframework.stereotype.Service;

/**
* @author zank
* @description 针对表【city】的数据库操作Service实现
* @createDate 2025-06-03 14:58:31
*/
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
    implements CityService{

}




