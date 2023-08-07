package com.CRM.Backend.servicesInterfaces;

import com.CRM.Backend.entities.Caise;


import java.util.List;

public interface CaiseInterface {

    public List<Caise> RetrieveAllCaise();
    public void DeleteCaise(Integer id);
    public Caise RetrieveCaiseById(Integer id);
    public Caise AddCaise(Caise caise);
    public Caise UpdateCaise(Caise caise, Integer id);


}
