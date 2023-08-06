package com.param.util;

import com.param.dto.response.ResponseService;

public class ResponseUtil {
    public static ResponseService setResponse(Constant.RESPONSE response, Object data){
        ResponseService responseService = new ResponseService();
        responseService.setRespCode(response.getCode());
        responseService.setRespDesc(response.getDescription());
        responseService.setData(data);
        return responseService;
    }
}
