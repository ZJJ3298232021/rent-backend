package site.webzank.rent.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.common.util.ThreadLocalUtil;
import site.webzank.rent.pojo.dto.ReserveDto;
import site.webzank.rent.pojo.vo.HistoryVo;
import site.webzank.rent.pojo.vo.ReservationVo;
import site.webzank.rent.service.ReservationService;

import java.util.List;

/**
 * @author zank
 */
@RestController
@RequestMapping("/auth/house")
@Slf4j
@RequiredArgsConstructor
public class ReserveController {
    private final ReservationService reservationService;

    @PostMapping("/reservation")
    public Result<ReservationVo> reserve(@RequestBody ReserveDto dto) {
        log.info("预约参数：{}", dto);
        return Result.success(reservationService.reserve(dto));
    }

    @GetMapping("/history")
    public Result<List<HistoryVo>> history() {
        log.info("user {}请求历史记录", ThreadLocalUtil.getCurrentInfo().getId());
        return Result.success(reservationService.history());
    }

}
