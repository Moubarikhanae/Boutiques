import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { CategorieServiceService } from 'src/app/services/categorieService/categorie-service.service';

@Component({
  selector: 'app-create-categorie',
  templateUrl: './create-categorie.component.html',
  styleUrls: ['./create-categorie.component.css']
})
export class CreateCategorieComponent implements OnInit {

  categorie: Categorie = new Categorie();
  submitted = false;
  errorMessage: string ;
  constructor(private categorieService: CategorieServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  save() {
    this.categorieService
    .createCategorie(this.categorie).subscribe(
      (data:any)=> {this.categorie = new Categorie();
      this.goToList();
      },
      (error: any) => {
        this.errorMessage = error.error.message;
        console.log(error)
      }
    );
  }

  onSubmit() {
    this.submitted=true;
    this.save();    
  }

  goToList() {
    this.router.navigate(['/categories-list']);
  }
}
