package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.Product;
import com.CRM.Backend.entities.dto.CaiseDto;
import com.CRM.Backend.repositories.CaiseRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.CaiseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Caise RetrieveCaiseById(Integer id)
    {
        try {
            Optional<Caise> caiseOptional = car.findById(id);

            if (caiseOptional.isPresent()) {
                return caiseOptional.get();
            } else {
                System.out.println("Caise with ID {} not found" +id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error retrieving caise by ID " + id + e);
            throw new RuntimeException("Error retrieving caise by ID"+ e);
        }
    }


    @Override
    public Caise AddCaise(CaiseDto caise) {
        Caise caisetoadd = new Caise();
        caisetoadd.setResponsable(caise.getResponsable());
        caisetoadd.setType(caise.getType());
        return car.save(caisetoadd);
    }


    @Override
    public Caise UpdateCaise(Caise caise, Integer id) {
        if (car.findById(id).isPresent())
        {return car.save(caise);}
        else {System.out.println("erreur update");return  null ;}
    }
}


