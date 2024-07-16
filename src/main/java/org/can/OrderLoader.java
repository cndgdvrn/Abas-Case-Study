package org.can;

import org.can.pojo.Order;

import java.util.List;

public class OrderLoader {


    public static List<Order> initData(){

        return List.of(
                new Order(1000,2000,12,100.51),
                new Order(1000,2001,31,200),
                new Order(1000,2002,22,150.86),
                new Order(1000,2003,41,250),
                new Order(1000,2004,55,244),

                new Order(1001,2001,88,44.531),
                new Order(1001,2002,121,88.11),
                new Order(1001,2004,74,211),
                new Order(1001,2002,14,88.11),

                new Order(1002,2003,2,12.1),
                new Order(1002,2004,3,22.3),
                new Order(1002,2003,8,12.1),
                new Order(1002,2002,16,94),
                new Order(1002,2005,9,44.1),
                new Order(1002,2006,19,90)
        );
    }
}
