package site.webzank.rent.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.webzank.rent.pojo.entity.HomeAd;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author zank
* @description 针对表【home_ad】的数据库操作Mapper
* @createDate 2025-06-03 14:58:31
* @Entity site.webzank.rent.pojo.entity.HomeAd
*/
@Mapper
public interface HomeAdMapper extends BaseMapper<HomeAd> {

}




