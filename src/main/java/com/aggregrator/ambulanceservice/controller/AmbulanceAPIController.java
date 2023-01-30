package com.aggregrator.ambulanceservice.controller;

import com.aggregrator.ambulanceservice.model.Ambulance;
import com.aggregrator.ambulanceservice.model.dto.AmbulanceDTO;
import com.aggregrator.ambulanceservice.service.AmbulanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class AmbulanceAPIController {

    @Autowired
    AmbulanceService ambulanceService;


    @GetMapping(value = "/ambulance/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(HttpStatus.OK).body("Test is successful");

    }


    @GetMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> getAmbulanceDetail(@PathVariable(value = "id") Long ambulanceId) {

          Ambulance ambulance = ambulanceService.getAmbulanceDetail(ambulanceId);
        return ResponseEntity.status(HttpStatus.OK).body(ambulance);

    }


        @Operation(summary = "Get Ambulance List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of ambulances",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation =   Ambulance.class))
                    })
    })
    @GetMapping(value = "/ambulance/list")

    public ResponseEntity<Iterable<Ambulance>> ambulanceList(@RequestParam(value = "city", required = false) String cityName,
                                                         @RequestParam(value ="lat", required = false) Double lat,
                                                         @RequestParam(value = "lon", required = false) Double lon) {
        Iterable<Ambulance> ambulanceList = ambulanceService.getAmbulanceList();
                return ResponseEntity.status(HttpStatus.OK).body(ambulanceList);
    }

    @Operation(summary = "Create Ambulance  ")
    @PostMapping(value = "/ambulance")
    public ResponseEntity<Ambulance> createAmbulanceList(@RequestBody AmbulanceDTO ambulanceDTO) {
        System.out.println(ambulanceDTO);
       Ambulance createdAmbulance = ambulanceService.createAmbulance(ambulanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAmbulance);

    }

    @PutMapping(value = "/ambulance/{id}")
    public ResponseEntity<Ambulance> updateAmbulance(@PathVariable(value="id") Long ambulanceID,@Valid @RequestBody AmbulanceDTO ambulanceDTO) {
        Ambulance updatedAmbulance = ambulanceService.updateAmbulance(ambulanceID,ambulanceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAmbulance);
    }


    @DeleteMapping(value = "/ambulance/{id}")
    public ResponseEntity<String> deleteAmbulance(@PathVariable(value ="id") String ambulanceID) {
        System.out.println(ambulanceID);
        ambulanceService.deleteAmbulance(Long.valueOf(ambulanceID));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }
}