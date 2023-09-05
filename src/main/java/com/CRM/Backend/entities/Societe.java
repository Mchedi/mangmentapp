    package com.CRM.Backend.entities;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import lombok.Data;

    import javax.persistence.*;
    import java.util.Set;

    @Data
    @Entity

    public class Societe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

                private Long id;
                private String Name;
                private long chiffre_affaire;
                private  int maricule_fiscale  ;
                private String adress;

        @OneToOne
        @JsonIgnore

        private MyUser creator;

        // One-to-many relationship with workers (MyUser)
        @JsonIgnore
        @OneToMany(mappedBy = "societeWork", cascade = CascadeType.ALL)
        private Set<MyUser> workers;


        @ManyToMany(cascade = CascadeType.ALL)
        private Set<Product> Products;
        @OneToOne
        Sub subs;


    }
