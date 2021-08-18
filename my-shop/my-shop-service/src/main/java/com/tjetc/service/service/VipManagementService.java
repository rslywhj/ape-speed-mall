package com.tjetc.service.service;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.entity.User;
import com.tjetc.service.entity.VipManagement;

public interface VipManagementService {
    /**
     * 分页查询VipManagement
     *
     * @param pageNo   页码
     * @param pageSize 每页数量
     * @return
     */
    AdminPageResult<VipManagement> page(int pageNo, int pageSize);
}
