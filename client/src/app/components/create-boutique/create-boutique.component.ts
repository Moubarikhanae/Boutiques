import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Boutique } from 'src/app/models/boutique';
import { BoutiqueServiceService } from 'src/app/services/boutiqueService/boutique-service.service';

@Component({
  selector: 'app-create-boutique',
  templateUrl: './create-boutique.component.html',
  styleUrls: ['./create-boutique.component.css']
})
export class CreateBoutiqueComponent implements OnInit {

  boutique: Boutique = new Boutique();
  submitted = false;
  errorMessage:string;
  boutiqueForm: FormGroup;

  constructor(private router: Router, private fb: FormBuilder,
     private boutiqueService: BoutiqueServiceService) { 
      this.boutiqueForm = this.fb.group({
        nom : '',
        conge : false,
        ouvertures : this.fb.array([]),
      })
     }

  ouvertures() : FormArray {
    return this.boutiqueForm.get("ouvertures") as FormArray
  }

  ngOnInit(): void {

  }

  newOuverture(): FormGroup {
    return this.fb.group({
      jour: '',
      horaireOuverture: '',
      horaireFermeture: ''
    })
  }

  addOuverture() {
    this.ouvertures().push(this.newOuverture());
  }
   
  removeOuverture(i:number) {
    this.ouvertures().removeAt(i);
  }

  save() {
    this.boutiqueService
    .createBoutique(this.boutiqueForm.value).subscribe(data => {
      console.log(data)
      this.boutique = new Boutique();
      this.gotoList();
    }, 
    error => {
     this.errorMessage = error.error.message;
      console.log(error)
    });
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  
  gotoList() {
    this.router.navigate(['/produits-list']);
  }
}
