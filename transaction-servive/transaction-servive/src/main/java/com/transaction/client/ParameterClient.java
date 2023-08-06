package com.transaction.client;

import com.transaction.config.FeignClientConfig;
import com.transaction.dto.response.DiscountResponse;
import com.transaction.dto.response.ParameterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "param-service", url = "${parameter.service.path}", configuration = FeignClientConfig.class)
public interface ParameterClient {
    @RequestMapping(method = RequestMethod.GET, path = "/getparam")
    ParameterResponse getParam(@RequestParam("key") String key);

    @RequestMapping(method = RequestMethod.GET, path = "/getdiscount")
    DiscountResponse getDiscount(@RequestParam("totalTrx") Integer totalTrx);
}