package site.webzank.rent.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.common.util.ThreadLocalUtil;
import site.webzank.rent.pojo.dto.LoginDto;
import site.webzank.rent.pojo.dto.MailDto;
import site.webzank.rent.pojo.vo.LoginVo;
import site.webzank.rent.pojo.vo.UserInfoVo;
import site.webzank.rent.service.UserInfoService;

/**
 * @author zank
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserInfoService userInfoService;

    /**
     * 发送邮箱验证码
     *
     * @param mail 收件人邮箱
     * @return 验证码
     */
    @PostMapping("/sendMailCode")
    public Result<Integer> sendMailCode(@RequestBody MailDto mail) {
        log.info("邮箱：{}", mail.getMail());
        int code = userInfoService.sendMailCode(mail.getMail());
        return Result.success(code);
    }

    /**
     * 登录
     *
     * @param loginDto 邮箱和验证码
     * @return token
     */
    @PostMapping("/login")
    public Result<LoginVo> login(@RequestBody LoginDto loginDto) {
        log.info("邮箱：{}", loginDto.getMail());
        log.info("验证码：{}", loginDto.getCode());
        return userInfoService.login(loginDto.getMail(), loginDto.getCode());
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("/auth/user/userInfo")
    public Result<UserInfoVo> getUserInfo() {
        log.info("用户id：{}", ThreadLocalUtil.getCurrentInfo().getId());
        return Result.success(userInfoService.getInfo());
    }
}
