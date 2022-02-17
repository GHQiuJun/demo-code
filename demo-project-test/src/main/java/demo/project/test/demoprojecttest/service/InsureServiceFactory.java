package demo.project.test.demoprojecttest.service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import demo.project.test.demoprojecttest.component.BeanUtils;

import java.util.HashMap;

/**
 * @program: InsureServiceFactory
 * @description: 构建产品所需的Service工厂
 * @author: 60007949
 * @create: 2022-01-12 16:05
 **/
public class InsureServiceFactory {

    final private String productCode;

    public InsureServiceFactory(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 根据产品编码获取对应的保司对接实现类
     *
     * @return serviceName
     */
    private String getServiceName() {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("001", "PinAnTwoStepOrderService");
        map.put("002", "TaiKangTwoStepOrderService");
        return map.get(productCode);
    }

    /**
     * 获取对应产品的保司对接实现类
     *
     * @return AbstractInsureTwoStepOrderService
     */
    public AbstractInsureTwoStepOrderService getInstance() {
        return (AbstractInsureTwoStepOrderService) BeanUtils.getBean(getServiceName());
    }
}
