package org.can;


import org.can.pojo.Order;
import org.can.questions.GetQuestion;
import org.can.questions.PostQuestion;
import org.can.questions.ProductQuestion;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Order> orderList = OrderLoader.initData();

        //1.a
        ProductQuestion.calculateTotalPrice(orderList);

        //1.b
        ProductQuestion.averagePrice(orderList);

        //1.c
        ProductQuestion.averagePriceOfProduct(orderList);

        //1.d
        ProductQuestion.quantityOfProduct(orderList);


        //2- Post Request - Response
        PostQuestion.postRequest();

        //2- Get Request - Response
        GetQuestion.getRequest();

    }


}
