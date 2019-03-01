package com.cahodental.util;

/*
 * Created by renhongjiang on 2019/2/22.
 */

import java.util.UUID;

/**
 * TODO
 *
 * @author renhongjiang
 * @version 1.0
 * @date 2019/2/22 16:32
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

}