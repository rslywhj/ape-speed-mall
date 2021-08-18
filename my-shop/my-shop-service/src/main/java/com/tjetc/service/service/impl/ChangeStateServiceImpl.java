package com.tjetc.service.service.impl;

import com.tjetc.service.common.model.AdminPageResult;
import com.tjetc.service.dao.ChangeStateDao;
import com.tjetc.service.dao.impl.ChangeStateDaoImpl;
import com.tjetc.service.service.ChangeStateService;

public class ChangeStateServiceImpl implements ChangeStateService {
     ChangeStateDao changeStateDao=new ChangeStateDaoImpl();
    @Override
    public AdminPageResult<Boolean> DeliverGoods(Long id) {
        AdminPageResult<Boolean> booleanAdminPageResult = changeStateDao.DeliverGoods(id);
        return booleanAdminPageResult;
    }

    @Override
    public AdminPageResult<Boolean> Refund(Long id) {
        AdminPageResult<Boolean> refund = changeStateDao.Refund(id);
        return refund;
    }
}
