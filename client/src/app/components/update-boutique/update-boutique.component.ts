import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Boutique } from 'src/app/models/boutique';
import { BoutiqueServiceService } from 'src/app/services/boutiqueService/boutique-service.service';

@Component({
  selector: 'app-update-boutique',
  templateUrl: './update-boutique.component.html',
  styleUrls: ['./update-boutique.component.css']
})
export class UpdateBoutiqueComponent implements OnInit {

  id: number;
  boutique: Boutique = new Boutique();
  submitted = false;
  errorMessage:string;
  boutiqueForm: FormGroup;

  
  constructor(private router: Router, private fb: FormBuilder,
    private boutiqueService: BoutiqueServiceService, private route: ActivatedRoute) { 
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

      this.id = this.route.snapshot.params['id'];

      this.boutiqueService.getBoutique(this.id)
      .subscribe(
        data => {
        console.log(JSON.stringify(data.ouvertures))
        this.boutiqueForm.patchValue({
          nom: data.nom,
          conge: data.conge,
        });
        const ouvertures = this.boutiqueForm.get('ouvertures') as FormArray;
        for (let i = 0; i < data.ouvertures.length; i++) {
          let tmp = this.fb.group({
            jour: data.ouvertures[i].jour,
            horaireOuverture: data.ouvertures[i].horaireOuverture,
            horaireFermeture: data.ouvertures[i].horaireFermeture
          })
            ouvertures.push(tmp);
           // console.log(ouvertures.at(i))
            //console.log(this.boutiqueForm.get('ouvertures'))
        }
        console.log(this.boutiqueForm.get("ouvertures"))
         
        },
        error => console.log(error)
      );
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
      .updateBoutique(this.id, this.boutiqueForm.value).subscribe(data => {
        console.log(data)
        this.boutique = new Boutique();
        this.gotoList();
      }, 
      error => {
       this.errorMessage = error.nom;
        console.log(error)
      });
    }
  
    onSubmit() {
      this.submitted = true;
      this.save();    
    }
  
    
    gotoList() {
      this.router.navigate(['/list-boutiques']);
    }

}
