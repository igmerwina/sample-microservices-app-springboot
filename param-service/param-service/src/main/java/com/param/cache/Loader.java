package com.param.cache;

import com.param.dto.response.ParameterResponse;
import com.param.entity.ParameterCache;
import com.param.repo.ParameterCacheRepo;
import com.param.repo.ParameterRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Loader {
    private final ParameterRepo parameterRepo;
    private final ParameterCacheRepo parameterCacheRepo;

    @Bean
    public void load() {
        log.info("--> Start to Load All Data Parameter & Put To Redis");
        // put to redis
        parameterRepo.findAll().forEach(item -> {
            ParameterResponse paramResp = ParameterResponse.builder()
                    .key(item.getKey())
                    .description(item.getDescription())
                    .value(item.getValue())
                    .build();

            ParameterCache param = ParameterCache.builder()
                    .id(item.getKey())
                    .parameterResponse(paramResp)
                    .build();

            parameterCacheRepo.save(param);
        });
    }
}
