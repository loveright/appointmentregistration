package com.by.appregistration.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.by.appregistration.model.order.PaymentInfo;
import com.by.appregistration.model.order.RefundInfo;

public interface RefundInfoService extends IService<RefundInfo> {

    /**
     * 保存退款记录
     * @param paymentInfo
     */
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);

}
