package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.common.util.JwtUtil;
import site.webzank.rent.common.util.ThreadLocalUtil;
import site.webzank.rent.mapper.UserInfoMapper;
import site.webzank.rent.pojo.entity.UserInfo;
import site.webzank.rent.pojo.vo.LoginVo;
import site.webzank.rent.pojo.vo.UserInfoVo;
import site.webzank.rent.service.UserInfoService;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zank
 * @description 针对表【user_info】的数据库操作Service实现
 * @createDate 2025-06-03 14:58:31
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {
    private final UserInfoMapper userInfoMapper;
    private final MailService mailService;
    private final StringRedisTemplate redisTemplate;

    @Override
    public int sendMailCode(String mail) {
        //发送验证码
        Random random = new Random();
        //六位数验证码
        int code = random.nextInt(1000000);
        try {
            mailService.sendMail(mail, code);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //缓存验证码 不保存对象信息

        String s = String.valueOf(code);
        redisTemplate.opsForValue().set(mail, s, 60, TimeUnit.MINUTES);

        return code;
    }

    @Override
    public Result<LoginVo> login(String mail, String code) {
        String realCode = redisTemplate.opsForValue().get(mail);
        if (Objects.isNull(realCode)) {
            return Result.error("验证码已失效");
        }
        //验证码验证成功
        log.info("验证码：{},{},{}", realCode, code, realCode.equals(code));

        if (realCode.equals(code)) {
            //删除验证码
            redisTemplate.delete(mail);
            LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserInfo::getMail, mail);
            UserInfo userInfo = userInfoMapper.selectOne(wrapper);
            //未注册则注册
            if (Objects.isNull(userInfo)) {
                userInfo = UserInfo
                        .builder()
                        .img("https://pic1.imgdb.cn/item/683ef7c158cb8da5c8294e41.png")
                        .nickname("小咕咕" + mail.substring(mail.indexOf("@") + 1, mail.indexOf(".")) + mail.substring(0, mail.indexOf("@")))
                        .mail(mail)
                        .build()
                ;
                userInfoMapper.insert(userInfo);
            }
            return Result.success(LoginVo.builder().token(JwtUtil.generateToken(userInfo)).build());

        }
        return Result.error("验证码错误");
    }

    @Override
    public UserInfoVo getInfo() {
        UserInfo userInfo = ThreadLocalUtil.getCurrentInfo();
        return UserInfoVo
                .builder()
                .id(userInfo.getId())
                .nickname(userInfo.getNickname())
                .avatar(userInfo.getImg())
                .build();
    }

}




