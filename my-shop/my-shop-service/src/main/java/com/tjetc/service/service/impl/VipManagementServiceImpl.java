package com.tjetc.service.service.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.dao.VipManagementDao;
import com.tjetc.service.dao.impl.VipManagementDaoImpl;
import com.tjetc.service.entity.VipManagement;
import com.tjetc.service.service.VipManagementService;

public class VipManagementServiceImpl implements VipManagementService {
    VipManagementDao vipManagementDao = new VipManagementDaoImpl();
    @Override
    public AdminPageResult<VipManagement> page(int start, int pageSize) {
    return vipManagementDao.selectPage(start, pageSize);
    }
}
