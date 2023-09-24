    package com.CRM.Backend.entities;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import lombok.Data;

    import javax.persistence.*;
    import java.util.Date;
    import java.util.Objects;
    import java.util.Set;

        @Data
    @Entity

    public class Societe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

                private Long id;
                private String Name;
                private int chiffre_affaire;
                private  int maricule_fiscale  ;
                private String adress;
            @Temporal(TemporalType.DATE)
            private Date sub_purchase_date ;
            @Temporal(TemporalType.DATE)
            private Date sub_expiration_date ;
            @OneToOne
            SubOption subs;

        @OneToOne
        @JsonIgnore

        private MyUser creator;

        // One-to-many relationship with workers (MyUser)
        @JsonIgnore
        @OneToMany(mappedBy = "societeWork", cascade = CascadeType.ALL)
        private Set<MyUser> workers;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Societe)) return false;
                Societe societe = (Societe) o;
                return getChiffre_affaire() == societe.getChiffre_affaire() && getMaricule_fiscale() == societe.getMaricule_fiscale() && Objects.equals(getId(), societe.getId()) && Objects.equals(getName(), societe.getName()) && Objects.equals(getAdress(), societe.getAdress()) && Objects.equals(getCreator(), societe.getCreator()) && Objects.equals(getWorkers(), societe.getWorkers()) && Objects.equals(getSubs(), societe.getSubs());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getId(), getName(), getChiffre_affaire(), getMaricule_fiscale(), getAdress(), getCreator(), getWorkers(), getSubs());
            }



    }
