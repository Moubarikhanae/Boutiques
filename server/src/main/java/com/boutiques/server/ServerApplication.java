package com.boutiques.server;

import com.boutiques.server.entities.Boutique;
import com.boutiques.server.entities.Categorie;
import com.boutiques.server.entities.Ouverture;
import com.boutiques.server.entities.Produit;
import com.boutiques.server.repositories.BoutiqueRepository;
import com.boutiques.server.repositories.CategorieRepository;
import com.boutiques.server.repositories.OuvertreRepository;
import com.boutiques.server.repositories.ProduitRepository;
import com.boutiques.server.services.interfaces.ICategorieService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@OpenAPIDefinition(info = @Info(title = "Spring Boot REST API",version = "1.0",
		description = "Cette application a pour but la gestion des boutiques, les produits et les catégories"))
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


	@Bean
	public CommandLineRunner start(CategorieRepository categorieRepository,
								   BoutiqueRepository boutiqueRepository,
								   ProduitRepository produitRepository,
								   OuvertreRepository ouvertreRepository)
	{
		return args->{
			if(categorieRepository.findAll().size()==0
			&& produitRepository.findAll().size()==0
			&& boutiqueRepository.findAll().size()==0) {
				int count = 1;
				for (int i=1 ; i<=10 ; i++) {
					Categorie categorie = new Categorie();
					categorie.setNom("Categorie"+i);
					categorieRepository.save(categorie);
				}
				for (int i=1 ; i<=10 ; i++) {

					Boutique boutique = new Boutique();
					boutique.setNom("Boutique"+i);
					boutique.setDateCreation(Date.valueOf(LocalDate.now()));
					List<Ouverture> ouvertures = new ArrayList<>();
					for(int j=1; j<=5;j++) {
						for(int k=1;k<=2;k++) {
							Ouverture ouverture = new Ouverture();
							ouverture.setJour(i);
							ouverture.setHoraireOuverture(Time.valueOf("08:00:00"));
							ouverture.setHoraireFermeture(Time.valueOf("12:00:00"));
							ouvertures.add(ouverture);
						}
					}
					boutique.setOuvertures(ouvertures);
					boutiqueRepository.save(boutique);
					boutique.getOuvertures().forEach(ouverture -> {
						ouverture.setBoutique(boutique);
						if(ouverture.getJour() == 0) ouverture.setJour(1);
						ouvertreRepository.save(ouverture);
					});
					//insertion des produits
					for(int z=1 ; z<=10 ; z++) {
						Produit produit = new Produit();
						produit.setNom("Produit"+ count);
						count++;
						produit.setDescription("Description produit"+z);
						produit.setPrix(10);
						produit.setQuantite(10L);
						Categorie categorie = new Categorie();
						categorie.setId(Long.valueOf(z));
						produit.getCategorieSet().add(categorie);
						produit.setBoutique(new Boutique());
						produit.getBoutique().setId(boutique.getId());
						produitRepository.save(produit);
					}
				}

			}
		};
	}

}
