    package com.CRM.Backend.entities;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import lombok.Data;

    import javax.persistence.*;
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

        @OneToOne
        @JsonIgnore

        private MyUser creator;

        // One-to-many relationship with workers (MyUser)
        @JsonIgnore
        @OneToMany(mappedBy = "societeWork", cascade = CascadeType.ALL)
        private Set<MyUser> workers;






        @OneToOne
        Sub subs;


    }
