package com.xm.study.pattern.observer.order.model.bean;

/**
 * @author: xm on 2017/7/31.
 * @describe: 商品
 */

public class Goods {
    private long goodsId;
    private String goodsName;
    private double goodsSrice;
    private long goodsNumAll;//总数（包括购物车中的）
    private long goodsNum;//浮动数量（购物车、订单）
    private int goodsState;//0商家、1：购物车、2订单（待付款）、3订单（待发货）、4订单（待收货）、5订单（待评价）、6订单（退货）
    private String firmName;//厂商的名字
    private long firmId;
}
