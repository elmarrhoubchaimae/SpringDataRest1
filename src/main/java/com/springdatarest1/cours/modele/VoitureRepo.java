package com.springdatarest1.cours.modele;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.util.List;
@RepositoryRestResource
@Repository
public interface VoitureRepo extends CrudRepository<Voiture, Long> {


    // Sélectionnez les voitures par année
    List<Voiture> findByAnnee(int annee);
    // Sélectionnez les voitures par marque et modele
    List<Voiture> findByMarqueAndModele(String marque, String modele);
    // Sélectionnez les voitures par marque ou couleur
    List<Voiture> findByMarqueOrCouleur(String marque, String couleur);
    // Sélectionnez les voitures par marque et trier par annee
    List<Voiture> findByMarqueOrderByAnneeAsc(String marque);
    // Sélectionnez les voitures par marque en utilisant SQL
    @Query("select v from Voiture v where v.marque = ?1")
    List<Voiture> findByMarque(String marque);
    @Query("select v from Voiture v where v.marque like %?1")
    List<Voiture> findByMarqueEndsWith(String marque);
    List<Voiture> findByCouleur(@Param("couleur") String couleur);

}