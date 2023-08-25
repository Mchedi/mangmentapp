package com.CRM.Backend.services;

import com.CRM.Backend.entities.Caise;
import com.CRM.Backend.entities.dto.CaiseDto;


import java.util.List;

public interface CaiseInterface {

    public List<Caise> RetrieveAllCaise();
    public void DeleteCaise(Integer id);
    public Caise RetrieveCaiseById(Integer id);
    public Caise AddCaise(CaiseDto caise);
    public Caise UpdateCaise(Caise caise, Integer id);


}
