package com.xm.study.pattern.observer.order.model.pay;

/**
 * @author: xm on 2017/7/31.
 * @describe: 付款这个动作，为主题。
 * 付款的情况：1、生成订单、立即付款、付款成功（待付款中数据一闪而过--最后状态：待发货）。2、生成订单、立即付款、付款失败（最后状态--待付款）。3、生成订单、取消付款、待付款（最后状态--待付款）。
 * 此处的观察者：待付款、待发货。不涉及购物车，把付款这个动作直接从待付款这个状态下执行。生成订单这个动作影响购物车的。
 * 一般正常的订单：生成订单、待付款、待发货、待收货、待确认。
 * 退货订单：生成订单、待付款、（已付款）退货中。
 * 取消订单：生成订单、（未付款）取消订单。
 */

public class ComplPayObservable {
}
