package com.transaction.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.dto.response.ResponseService;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class CustomDecoder implements Decoder {
    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        ResponseService responseService;

        ObjectMapper mapper = new ObjectMapper();
        responseService = mapper.readValue(response.body().asReader(), ResponseService.class);

        return mapper.convertValue(responseService.getData(), (Class) type);
    }
}
