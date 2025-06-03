package site.webzank.rent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import site.webzank.rent.pojo.entity.UserInfo;
import site.webzank.rent.service.UserInfoService;
import site.webzank.rent.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author zank
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2025-06-03 14:58:31
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




