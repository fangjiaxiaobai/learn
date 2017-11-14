package com.fxb.aspectj;

import com.fxb.target.Seller;
import com.fxb.target.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author wangxiyue on 2017/9/28 14:02.
 * @description
 *
 *      在EnableSellerAspect切面中，
 *      通过@DeclareParents为NaiveWaiter添加了一个需要实现的Seller接口。
 *      并指定其默认实现类为SmartSeller，
 *      然后通过切面技术奖SmartSeller融合到NaiveWaiter，这样NaiveWaiter就实现了Seller接口。
 *
 */
@Aspect
public class EnableSellerAspect {
    
    @DeclareParents(value = "com.fxb.target.NaiveWaiter",defaultImpl = SmartSeller.class)
    public Seller seller;
}
