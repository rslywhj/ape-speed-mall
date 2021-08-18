
package com.tjetc.user.common;

import com.tjetc.user.entity.Address;
import com.tjetc.user.entity.CartAndPro;

import java.util.List;

public class Result {
    List<CartAndPro> cartAndPros;


    public Result() {
    }


    public Result(List<CartAndPro> cartAndPros) {
        this.cartAndPros = cartAndPros;
    }
}
