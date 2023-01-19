import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProduitServiceService } from 'src/app/services/produitService/produit-service.service';

@Component({
  selector: 'app-ajout-produit',
  templateUrl: './ajout-produit.component.html',
  styleUrls: ['./ajout-produit.component.css']
})
export class AjoutProduitComponent implements OnInit {
  public produitForm!: FormGroup;

  nom = new FormControl('', [Validators.required]);
  description = new FormControl('');
  categorie = new FormControl('', [Validators.required]);
  prix = new FormControl('', [Validators.required]);


  //getters for form fields
  get getNom() { return this.produitForm.get('nom')?.value; }
  get getDescription() { return this.produitForm.get('description')?.value; }
  get getCategorie() { return this.produitForm.get('catégorie')?.value; }
  get getPrix() { return this.produitForm.get('prix')?.value; }
   

  constructor(private produitService : ProduitServiceService) { 
    this.produitForm = new FormGroup({
      getNom : this.nom,
      getDescription : this.description,
      getCategorie: this.categorie,
      getPrix : this.prix

    })
  }

  ngOnInit(): void {
  }
  onSubmit(){
    this.produitService.addProduit(this.getNom, this.getDescription, this.getCategorie, this.getPrix).subscribe(
    (response) => {
      alert("le produit a été rajouté avec succès");
      this.produitForm.reset()
    
    });
  }
  

 }


