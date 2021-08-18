package com.tjetc.user.dao;

import com.tjetc.user.entity.CartAndPro;

import java.util.List;

public interface CartOderDao {
    List<CartAndPro> SelectPrice(Long vid, Long gid);
}
