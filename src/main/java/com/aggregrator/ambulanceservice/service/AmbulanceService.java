package com.aggregrator.ambulanceservice.service;

import com.aggregrator.ambulanceservice.model.Ambulance;
import com.aggregrator.ambulanceservice.model.dto.AddressDTO;
import com.aggregrator.ambulanceservice.model.dto.AmbulanceDTO;
import com.aggregrator.ambulanceservice.exception.AmbulanceNotFoundException;
import com.aggregrator.ambulanceservice.repository.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AmbulanceService {

    @Autowired
    AmbulanceRepository ambulanceRepository;

    public Iterable<Ambulance>getAmbulanceList(){
        return ambulanceRepository.findAll();

    }

    public Ambulance getAmbulanceDetail(Long ambulanceId){
        Optional <Ambulance> optionalAmbulance = ambulanceRepository.findById(ambulanceId);
        if(optionalAmbulance.isPresent()){
            return optionalAmbulance.get();
        }else {
            throw new AmbulanceNotFoundException(String.format("getAmbulanceDetail - The ambulance with the id %id is not present",ambulanceId),404);
        }

    }

    public Ambulance createAmbulance(AmbulanceDTO ambulanceDTO){

        AddressDTO addressDTO = ambulanceDTO.getAddress();
//        Address address = new Address(addressDTO.getProvince(),addressDTO.getCity(),addressDTO.getAddress());
        Ambulance ambulance = new Ambulance(ambulanceDTO.getName(),ambulanceDTO.getLat(),ambulanceDTO.getLon(),ambulanceDTO.isOpened(),LocalDateTime.now());
        return ambulanceRepository.save(ambulance);

    }

    public Ambulance updateAmbulance(Long ambulanceId, AmbulanceDTO ambulanceDTO){
        Optional<Ambulance> optionalAmbulance = ambulanceRepository.findById(ambulanceId);

        if(optionalAmbulance.isPresent()) {
            Ambulance ambulanceToUpdate = optionalAmbulance.get();
            ambulanceToUpdate.setName(ambulanceDTO.getName());
            ambulanceToUpdate.setLon(ambulanceDTO.getLon());
            ambulanceToUpdate.setLat(ambulanceDTO.getLat());
            ambulanceToUpdate.setOpened(ambulanceDTO.isOpened());

            return ambulanceRepository.save(ambulanceToUpdate);
        }else {
            throw new AmbulanceNotFoundException(String.format("updateAmbulance - The ambulance with the id %id is not present",ambulanceId),404);


        }
//        List<String> phones = List.of("01-444567", "01-444789");
//        AddressDTO addressDTO = ambulanceDTO.getAddress();
//        Address address = new Address(addressDTO.getProvince(),addressDTO.getCity(),addressDTO.getAddress());
//        Ambulance ambulance = new Ambulance(ambulanceDTO.getName(),ambulanceDTO.getLat(),ambulanceDTO.getLon(),ambulanceDTO.isOpened());
//        return ambulanceRepository.save(ambulance);
    }

    public void deleteAmbulance(Long ambulanceId){
        try{
            ambulanceRepository.deleteById(ambulanceId);
        }catch (EmptyResultDataAccessException ex){
            throw new AmbulanceNotFoundException(String.format("deleteAmbulance - The ambulance with the id %id is not present",ambulanceId),404);
        }



    }

}
