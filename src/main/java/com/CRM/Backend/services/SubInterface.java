package com.CRM.Backend.services;

import com.CRM.Backend.entities.Sub;

import java.util.List;

public interface SubInterface {

    public List<Sub> RetrieveAllSubs();
    public void DeleteSub(Long id);
    public Sub RetrieveSubById(Long id);
    //public Sub AddSub(Sub sub);

    public String addSub(Sub sub);

    public Sub UpdateSub(Sub sub, Long id);
    void assignSublimToSub(Long subId, Long sublimId);


}
