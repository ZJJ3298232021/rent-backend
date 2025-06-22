package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.webzank.rent.common.util.ThreadLocalUtil;
import site.webzank.rent.mapper.HouseInfoMapper;
import site.webzank.rent.mapper.ReservationMapper;
import site.webzank.rent.pojo.dto.ReserveDto;
import site.webzank.rent.pojo.entity.HouseData;
import site.webzank.rent.pojo.entity.HouseInfo;
import site.webzank.rent.pojo.entity.Reservation;
import site.webzank.rent.pojo.vo.HistoryVo;
import site.webzank.rent.pojo.vo.ReservationVo;
import site.webzank.rent.service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zank
 * @description 针对表【reservation】的数据库操作Service实现
 * @createDate 2025-06-03 14:58:31
 */
@Service
@Slf4j
@AllArgsConstructor
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation>
        implements ReservationService {
    private final ReservationMapper reservationMapper;
    private final HouseInfoMapper houseInfoMapper;
    private final Gson gson;


    @Override
    public List<HistoryVo> history() {
        LambdaQueryWrapper<Reservation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Reservation::getUserId, ThreadLocalUtil.getCurrentInfo().getId());
        List<Reservation> reservations = reservationMapper.selectList(queryWrapper);
        List<HistoryVo> history = new ArrayList<>();
        reservations.forEach(reservation -> {
            LambdaQueryWrapper<HouseInfo> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(HouseInfo::getId, reservation.getHouseId());
            HouseInfo houseInfo = houseInfoMapper.selectOne(wrapper);
            HouseData houseData = gson.fromJson(houseInfo.getData(), HouseData.class);
            history.add(HistoryVo
                    .builder()
                    .houseId(reservation.getHouseId())
                    .date(reservation.getDate())
                    .id(reservation.getId())
                    .img("http://192.168.216.1:6060" + houseData
                            .getHousePicture()
                            .get(0)
                            .getPicList()
                            .get(0)
                    )
                    .tags(houseData.getTags())
                    .title(houseData.getHouseTitle())
                    .subTitle("")
                    .distanceInfo(houseData.getDistanceInfo())
                    .rentPrice(houseData.getRentPriceUnitListing() + houseData.getRentPriceUnit())
                    .comment(reservation.getComment())
                    .build());


        });
        return history;
    }

    @Override
    public ReservationVo reserve(ReserveDto dto) {
        Reservation insert = Reservation
                .builder()
                .userId(ThreadLocalUtil.getCurrentInfo().getId())
                .name(dto.getName())
                .houseId(dto.getHouseId())
                .date(dto.getDate())
                .comment(dto.getComment())
                .build();
        //date 转Date类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dto.getDate());
            if (date.before(new Date())) {
                throw new RuntimeException("日期错误");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Reservation select = Reservation
                .builder()
                .userId(ThreadLocalUtil.getCurrentInfo().getId())
                .houseId(dto.getHouseId())
                .date(dto.getDate())
                .build();
        LambdaQueryWrapper<Reservation> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.setEntity(select);
        Reservation reservation = reservationMapper.selectOne(queryWrapper);
        if (reservation != null) {
            throw new RuntimeException("您已在当日经预约过此房源");
        }
        reservationMapper.insert(insert);
        return ReservationVo.builder()
                .id(insert.getId())
                .userId(insert.getUserId())
                .houseId(insert.getHouseId())
                .date(insert.getDate())
                .name(insert.getName())
                .comment(insert.getComment())
                .build();
    }
}






