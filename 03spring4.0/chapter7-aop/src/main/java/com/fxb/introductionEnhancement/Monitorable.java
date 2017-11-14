package com.fxb.introductionEnhancement;

/**
 * @author 方小白 on 2017/9/27 9:32.
 * @description
 *   用于标识目标类是否支持性能监视的接口
 */
public interface Monitorable {
    
    // 通过该方法控制业务类性能监视功能的激活和关闭状态
    void setMonitorActive(Boolean active);
    
}
