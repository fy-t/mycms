package com.cms.modules.mapper;

import com.cms.modules.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by taifuyu on 17/6/30.
 */
@Mapper
public interface UserMapper {

    public Page<User> query(User user);
}
