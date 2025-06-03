package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import site.webzank.rent.pojo.entity.Reservation;
import site.webzank.rent.service.ReservationService;
import site.webzank.rent.mapper.ReservationMapper;
import org.springframework.stereotype.Service;

/**
* @author zank
* @description 针对表【reservation】的数据库操作Service实现
* @createDate 2025-06-03 14:58:31
*/
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation>
    implements ReservationService{

}




