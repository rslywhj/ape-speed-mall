package com.tjetc.service.service;

import com.tjetc.service.common.model.AdminPageResult;


public interface ChangeStateService {
    AdminPageResult<Boolean> DeliverGoods(Long id);
    AdminPageResult<Boolean> Refund(Long id);
}
