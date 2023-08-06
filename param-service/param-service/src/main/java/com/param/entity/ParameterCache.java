package com.param.entity;

import com.param.dto.response.ParameterResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@Builder(toBuilder = true)
@RedisHash("parameter")
public class ParameterCache {
    @Id
    private String id;
    private ParameterResponse parameterResponse;
}
