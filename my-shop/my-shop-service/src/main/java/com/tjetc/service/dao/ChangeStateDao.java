package com.tjetc.service.dao;

import com.tjetc.service.common.model.AdminPageResult;

public interface ChangeStateDao {
    AdminPageResult<Boolean> DeliverGoods(Long id);
    AdminPageResult<Boolean> Refund(Long id);
}
