import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ReactiveFormsModule } from '@angular/forms';
import { BoutiqueServiceService } from 'src/app/services/boutiqueService/boutique-service.service';





@Component({
  selector: 'app-ajout-boutique',
  templateUrl: './ajout-boutique.component.html',
  styleUrls: ['./ajout-boutique.component.css']
})
export class AjoutBoutiqueComponent implements OnInit {
  public boutiqueForm!: FormGroup;

  nom = new FormControl('', [Validators.required]);
  horaire = new FormControl('', [Validators.required]);
  conge = new FormControl('', [Validators.required]);
boutiqueFrom: any;
description: any;

  //getters for form fields
  get getNom() { return this.boutiqueForm.get('nom')?.value; }
  get getHoraire() { return this.boutiqueForm.get('horaire')?.value; }
  get getConge() { return this.boutiqueForm.get('conge')?.value; }

  constructor(private boutiqueService : BoutiqueServiceService) { 
    this.boutiqueForm = new FormGroup({
      getNom : this.nom,
      getHoraire: this.horaire,
      getConge: this.conge
    })
  }

  ngOnInit(): void {
  }
  onSubmit(){
    this.boutiqueService.addBoutique(this.getNom, this.getHoraire, this.getConge).subscribe(
      (response) => {
        alert("la boutique a été rajouté avec succès");
        this.boutiqueForm.reset()
      
      }
    );

  }
}
  export interface Item {
    userId: number;
  }
  


