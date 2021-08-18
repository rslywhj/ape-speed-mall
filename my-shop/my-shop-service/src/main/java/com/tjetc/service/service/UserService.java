package com.tjetc.service.service;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.User;

public interface UserService {
    /**
     * 分页查询user
     *
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return
     */
    AdminPageResult<User> page(int pageNo, int pageSize);
}
