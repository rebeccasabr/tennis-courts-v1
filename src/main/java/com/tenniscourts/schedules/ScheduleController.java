package com.tenniscourts.schedules;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/schedule/v1")
@Configuration
@ComponentScan("com.tenniscourts.schedules")
@AllArgsConstructor
public class ScheduleController extends BaseRestController {

	@Autowired
    private final ScheduleService scheduleService;

    //TODO: implement rest and swagger	
	//Para acessar as documentações das API'S com swagger,acessar a url:http://127.0.0.1:8080/swagger-ui.html, pois as dependencias do wagger encontra-se no arquivo build.gradle
	@RequestMapping(value = "/addScheduleTennisCourt/",method = RequestMethod.POST)
    public ResponseEntity<Void> addScheduleTennisCourt(CreateScheduleRequestDTO createScheduleRequestDTO) {
        return ResponseEntity.created(locationByEntity(scheduleService.addSchedule(createScheduleRequestDTO.getTennisCourtId(), createScheduleRequestDTO).getId())).build();
    }

    //TODO: implement rest and swagger
	//Para acessar as documentações das API'S com swagger,acessar a url:http://127.0.0.1:8080/swagger-ui.html, pois as dependencias do wagger encontra-se no arquivo build.gradle
	@RequestMapping(value = "/findSchedulesByDates/", method = RequestMethod.GET )
    public ResponseEntity<List<ScheduleDTO>> findSchedulesByDates(LocalDate startDate,LocalDate endDate) {
        return ResponseEntity.ok(scheduleService.findSchedulesByDates(LocalDateTime.of(startDate, LocalTime.of(0, 0)), LocalDateTime.of(endDate, LocalTime.of(23, 59))));
    }

    //TODO: implement rest and swagger: 
	//Para acessar as documentações das API'S com swagger,acessar a url:http://127.0.0.1:8080/swagger-ui.html, pois as dependencias do wagger encontra-se no arquivo build.gradle
	@RequestMapping(value = "/findByScheduleId/", method = RequestMethod.GET )
    public ResponseEntity<ScheduleDTO> findByScheduleId(Long scheduleId) {
        return ResponseEntity.ok(scheduleService.findSchedule(scheduleId));
    }
    
    
    
	@RequestMapping(value = "/findAllSchedule/", method =  RequestMethod.GET)
    public ResponseEntity<List<ScheduleDTO>> findAllSchedule(){
    	return ResponseEntity.ok(scheduleService.findAllSchedule());
    	
    }
    
    
}
