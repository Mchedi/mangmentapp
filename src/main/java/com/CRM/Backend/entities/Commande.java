package com.CRM.Backend.entities;

//import jdk.net.SocketFlow;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
    public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private Etat etat;
    private int montant;

    @OneToOne
    private Commande Commande;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        // Excluez la référence à Etat ici
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Commande other = (Commande) obj;
        if (id != other.id)
            return false;
        // Excluez la référence à Etat ici
        return true;
    }
}
