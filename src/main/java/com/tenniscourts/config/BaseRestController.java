package com.tenniscourts.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tenniscourts.schedules.CreateScheduleRequestDTO;
import com.tenniscourts.schedules.ScheduleDTO;

import springfox.documentation.annotations.ApiIgnore;

import java.net.URI;
import java.util.List;

@ApiIgnore
public class BaseRestController {

  protected URI locationByEntity(Long entityId){
        return ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(entityId).toUri();
    }


}
