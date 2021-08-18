package com.tjetc.service.dao;


import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.User;

public interface UserDao {
    /**
     * 分页查询数据
     *
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return
     */
    AdminPageResult<User> selectPage(int pageNo, int pageSize);
}
