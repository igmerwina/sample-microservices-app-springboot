package com.param.dto.response;


import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ResponseService {
    Object respCode, respDesc, data;

    public ResponseService() {
    }

    public ResponseService(Object respCode, Object respDesc, Object data) {
        this.respCode = respCode;
        this.respDesc = respDesc;
        this.data = data;
    }
}
