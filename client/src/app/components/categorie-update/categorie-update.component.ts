import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { CategorieServiceService } from 'src/app/services/categorieService/categorie-service.service';

@Component({
  selector: 'app-categorie-update',
  templateUrl: './categorie-update.component.html',
  styleUrls: ['./categorie-update.component.css']
})
export class CategorieUpdateComponent implements OnInit {

  id: number;
  categorie: Categorie;
  errorMessage: string ;
  submitted = false;
  constructor(private route: ActivatedRoute,private router: Router, 
    private categorieService: CategorieServiceService) { }

  ngOnInit(): void {
    this.categorie = new Categorie();

    this.id = this.route.snapshot.params['id'];

    this.categorieService.getCategorie(this.id)
    .subscribe(
      (data: any) => this.categorie = data,
      (error: any) => console.log(error)
    );
  }

  updateCategorie() {
    this.categorieService.updateCategorie(this.id, this.categorie)
      .subscribe(
        (data: any) => {
        console.log(data);
        this.categorie = new Categorie();
        this.gotoList();
      }, (error: any) => {console.log(error)
        this.errorMessage = error.error.message;
      });
  }

  onSubmit() {
    this.submitted = true;
    this.updateCategorie();    
  }

  gotoList() {
    this.router.navigate(['/categories-list']);
  }

}
