package com.CRM.Backend.services;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.repositories.CaiseRepository;
import com.CRM.Backend.repositories.ProductRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.servicesInterfaces.CaiseInterface;
import com.CRM.Backend.servicesInterfaces.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaiseServices implements CaiseInterface {

    @Autowired
    CaiseRepository car;
    @Autowired
    societeRepository sr;


    @Override
    public List<Caise> RetrieveAllCaise() {
        return car.findAll();
    }

    @Override
    public void DeleteCaise(Integer id) {
        car.deleteById(id);

    }

    @Override
    public Caise RetrieveCaiseById(Integer id) {
        return car.findById(id).get();
    }

    @Override
    public Caise AddCaise(Caise caise) {
        return car.save(caise);
    }

    @Override
    public Caise UpdateCaise(Caise caise, Integer id) {
        return car.save(caise);
    }
}



