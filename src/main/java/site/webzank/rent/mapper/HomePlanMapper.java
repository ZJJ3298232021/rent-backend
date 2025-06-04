package site.webzank.rent.mapper;

import org.apache.ibatis.annotations.Mapper;
import site.webzank.rent.pojo.entity.HomePlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author zank
* @description 针对表【home_plan】的数据库操作Mapper
* @createDate 2025-06-03 14:58:31
* @Entity site.webzank.rent.pojo.entity.HomePlan
*/
@Mapper
public interface HomePlanMapper extends BaseMapper<HomePlan> {

}




