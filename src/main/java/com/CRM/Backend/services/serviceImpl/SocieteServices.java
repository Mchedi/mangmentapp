package com.CRM.Backend.services.serviceImpl;

import com.CRM.Backend.entities.Dto.SocieteDTO;
import com.CRM.Backend.entities.MyUser;
import com.CRM.Backend.entities.Role;
import com.CRM.Backend.entities.Societe;
import com.CRM.Backend.entities.Sub;
import com.CRM.Backend.repositories.SubRepository;
import com.CRM.Backend.repositories.UserRepository;
import com.CRM.Backend.repositories.societeRepository;
import com.CRM.Backend.services.SocieteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocieteServices implements SocieteInterface {

    @Autowired
    UserRepository ur;
    @Autowired
    societeRepository sr;
    @Autowired
    SubRepository sur;

    @Override
    public List<Societe> RetrieveAllSociete() {
        return sr.findAll();
    }

    @Override
    public void DeletSociete(Long id) {
        sr.deleteById(id);
    }

    @Override
    public Societe RetrieveSocieteById(Long id) {
        return sr.findById(id).get();
    }

    @Override
    public Societe AddSociete(Societe soc) {
        return sr.save(soc);
    }

    @Override
    public Societe UpdateSociete(Societe societe, Long id) {
        return null;
    }

    @Override
    public Societe addAndAssignUserToSociete(Societe societe, Long userId) {
        MyUser user = ur.findById(userId).orElse(null);
        societe.setCreator(user);
        sr.save(societe);

        user.setSocieteWork(societe);
        ur.save(user);


        return societe;
    }


    public String assignSocieteToSub(Long societeId, Long subId) {
        Societe societe = sr.findById(societeId).orElse(null);
        Sub sub = sur.findById(subId).orElse(null);

        if (societe != null && sub != null) {
            societe.setSubs(sub);
            sr.save(societe);
            return "Societe assigned to Sub successfully";
        } else {
            return "Failed to assign Societe to Sub";
        }
    }
    public void inviteComptable(String directorEmail, String comptableEmail) {
        MyUser director = ur.findByMail(directorEmail).get();
        Societe directorSociete = director.getSocieteWork();
        MyUser comptable = ur.findByMailAndRole(comptableEmail, Role.comptable).get();
        comptable.setSocieteWork(directorSociete);
        ur.save(comptable);

    }
    public SocieteDTO getSocieteDTOByCreator(Long id) {
        Societe societe = sr.findByCreatorId(id).get()  ;
    List<MyUser> workers = ur.findAllBySocieteWorkId(societe.getId());
        List<String> workerNames = workers.stream()
                .map(MyUser::getName)
                .collect(Collectors.toList());

            return new SocieteDTO(
                    societe.getName(),
                    societe.getChiffre_affaire(),
                    societe.getMaricule_fiscale(),
                    societe.getAdress(),
                    workerNames
                    );

        }


}