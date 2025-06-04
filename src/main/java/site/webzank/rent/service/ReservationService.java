package site.webzank.rent.service;

import site.webzank.rent.pojo.dto.ReserveDto;
import site.webzank.rent.pojo.entity.Reservation;
import com.baomidou.mybatisplus.extension.service.IService;
import site.webzank.rent.pojo.vo.HistoryVo;
import site.webzank.rent.pojo.vo.ReservationVo;

import java.util.List;

/**
* @author zank
* @description 针对表【reservation】的数据库操作Service
* @createDate 2025-06-03 14:58:31
*/
public interface ReservationService extends IService<Reservation> {

    ReservationVo reserve(ReserveDto dto);

    List<HistoryVo> history();
}
