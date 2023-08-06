package com.param.controller;

import com.param.dto.response.ResponseService;
import com.param.service.ParameterService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/parameter")
public class ParamController {
    private final ParameterService parameterService;

    @GetMapping("/getparam")
    @ResponseBody
    public ResponseService getParameter(@RequestParam("key") @Validated String key) throws Exception {
        return parameterService.getParameter(key);
    }

    @GetMapping("/getdiscount")
    @ResponseBody
    public ResponseService getDiscount(@RequestParam("totalTrx") @Validated Integer totalTrx) throws Exception {
        return parameterService.getDiscount(totalTrx);
    }

}
