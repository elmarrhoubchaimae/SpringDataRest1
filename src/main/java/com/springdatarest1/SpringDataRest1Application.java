package com.springdatarest1;

import com.springdatarest1.cours.modele.Proprietaire;
import com.springdatarest1.cours.modele.ProprietaireRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdatarest1.cours.modele.Voiture;
import com.springdatarest1.cours.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRest1Application {

    @Autowired
    private VoitureRepo voitureRepo;

    @Autowired
    private ProprietaireRepo proprietaireRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRest1Application.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            Proprietaire proprietaire1 = new Proprietaire("Ali", "Hassan");
            Proprietaire proprietaire2 = new Proprietaire("Najat", "Bani");

            // Save Proprietaires
            proprietaireRepo.save(proprietaire1);
            proprietaireRepo.save(proprietaire2);
            // Insertion de données de test
            voitureRepo.save(new Voiture("Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000));
            voitureRepo.save(new Voiture("Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000));
            voitureRepo.save(new Voiture("Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000));

            // Vous pouvez ajouter autant de données de test que vous voulez ici
            System.out.println("Données de test ajoutées !");
        };
    }
}


