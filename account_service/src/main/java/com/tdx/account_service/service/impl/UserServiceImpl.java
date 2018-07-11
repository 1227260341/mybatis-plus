package com.tdx.account_service.service.impl;

import com.tdx.account_service.entity.User;
import com.tdx.account_service.dao.UserMapper;
import com.tdx.account_service.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzhenjang123
 * @since 2018-07-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
