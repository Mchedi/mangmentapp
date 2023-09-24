package com.CRM.Backend.controllers;

import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.SubOption;
import com.CRM.Backend.services.serviceImpl.SubOptionService;
import com.CRM.Backend.services.serviceImpl.SubServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/subOption")
public class SubOptionController {
    private final SubOptionService subOptionService;

    @PostMapping("/add")
    public SubOption addSubscription(@RequestBody SubOption sub) {
return subOptionService.AddSubOption (sub);
}
    @GetMapping("/getall")

    public List<SubOption> getAllUsers(){
        return subOptionService.Retrievesubsoption();
    }




}
