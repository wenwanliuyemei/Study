package com.xm.study.pattern.observer.order.model.generate;

/**
 * @author: xm on 2017/7/31.
 * @describe: 生成订单的这个动作，为主题。
 * 变化的：购物车、待付款订单、全部订单。
 * 支付这个动作是主题。
 *支付后：购物车商品变化；支付成功与否，都会生成订单（订单变化）。
 *订单变化：成功：待付款、待发货、待收货、所有订单。
 *待评价（主题--确认收货）。
 *退货／售后（主题--退货）。
 */

public class ComplGenerateObservable implements IGenerateObservable {

    public void pay(Object data){
        //访问接口，完成支付的动作
        //此处假定支付成功
    }

    /**
     *
     * @param what 1:下订单时立即支付，且支付ok，2：下订单时立即支付，且支付出问题，3：取消支付
     * @return
     */
//    public boolean payResult(int what){
//
//    }
}
