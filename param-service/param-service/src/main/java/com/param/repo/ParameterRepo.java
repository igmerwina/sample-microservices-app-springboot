package com.param.repo;

import com.param.entity.Parameter;
import org.springframework.data.repository.CrudRepository;

public interface ParameterRepo extends CrudRepository<Parameter, String> {

}
