package com.CRM.Backend.services;

import com.CRM.Backend.entities.Dto.SubDTO;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.entities.Sub;

import java.util.List;

public interface SubInterface {

    public List<Sub> RetrieveAllSubs();
    public void DeleteSub(Long id);

    List<SubDTO> getAllSubDTOs();

    public Sub RetrieveSubById(Long id);
    //public Sub AddSub(Sub sub);

    public String addSub(Sub sub);

    String addSub(Sub sub, Societe societe, Long userId);


    String addSubadign(Sub sub, Long userId);

    public Sub UpdateSub(Sub sub, Long id);
    void assignSublimToSub(Long subId, Long sublimId);
    public void checkAndLogExgetSubpiredSubscriptionsForAllSocietes() ;
     void logExpiredSubscription(Long subscriptionId, String societeName);


}
