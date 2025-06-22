package site.webzank.rent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.webzank.rent.common.result.Result;
import site.webzank.rent.pojo.entity.UserInfo;
import site.webzank.rent.pojo.vo.LoginVo;
import site.webzank.rent.pojo.vo.UserInfoVo;

/**
 * @author zank
 * @description 针对表【user_info】的数据库操作Service
 * @createDate 2025-06-03 14:58:31
 */
public interface UserInfoService extends IService<UserInfo> {
    int sendMailCode(String mail);

    Result<LoginVo> login(String mail, String code);

    UserInfoVo getInfo();
}
