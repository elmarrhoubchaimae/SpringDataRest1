package com.springdatarest1.cours.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private String marque;

    @NonNull
    private String modele;

    @NonNull
    private String couleur;

    @NonNull
    private String immatricule;

    @NonNull
    private int annee;

    @NonNull
    private int prix;

    // Association ManyToOne vers la classe Proprietaire
    @ManyToOne
    @JoinColumn(name = "proprietaire_id") // Vous pouvez spécifier un nom explicite pour la colonne
    @JsonIgnore

    private Proprietaire proprietaire;

    // Lombok va générer un constructeur pour les champs @NonNull, donc vous n'avez pas besoin de le déclarer manuellement
    // Vous pouvez aussi utiliser ce setter si vous souhaitez définir un Proprietaire après l'instanciation
}
