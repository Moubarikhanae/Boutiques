import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { CategorieServiceService } from 'src/app/services/categorieService/categorie-service.service';

@Component({
  selector: 'app-Ajout-categorie',
  templateUrl: './Ajout-categorie.component.html',
  styleUrls: ['./Ajout-categorie.component.css']
})
export class AjoutCategorieComponent implements OnInit {
  public categorieForm!: FormGroup;

  nom = new FormControl('', [Validators.required]);
  

  //getters for form fields
  get getNom() { return this.categorieForm.get('nom')?.value; }
  

  constructor(private categorieService : CategorieServiceService) {
    this.categorieForm = new FormGroup({
      getNom : this.nom
    })
   }

  ngOnInit(): void {
  }
  onSubmit(){
    this.categorieService.createCategory(this.getNom).subscribe(
    (response) => {
      alert("la catégorie a été rajouté avec succès");
      this.categorieForm.reset()
    
    }
  );


 }
}


