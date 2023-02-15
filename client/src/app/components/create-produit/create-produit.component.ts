import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Categorie } from 'src/app/models/categorie';
import { Produit } from 'src/app/models/produit';
import { CategorieServiceService } from 'src/app/services/categorieService/categorie-service.service';
import { ProduitServiceService } from 'src/app/services/produitService/produit-service.service';

@Component({
  selector: 'app-create-produit',
  templateUrl: './create-produit.component.html',
  styleUrls: ['./create-produit.component.css']
})
export class CreateProduitComponent implements OnInit {

  produit: Produit = new Produit();
  submitted = false;
  errorMessage: string;  
  id:number;
  categories: Categorie[];

  constructor(private produitService: ProduitServiceService,
    private router: Router, private route:ActivatedRoute, private categorieService: CategorieServiceService ) { }

  newProduit(): void {
    this.submitted  = false;
    this.produit = new Produit();
    
  }

  save() {
    this.produitService
    .createProduit(this.id, this.produit).subscribe((data:any) => {
      console.log(data)
      this.produit = new Produit();
      this.gotoList();
    }, 
    (error:any) => {
      this.errorMessage = error.error.message;
      console.log(error);
    });
  }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.categorieService.getCategoriesList().subscribe(
      (data:any) => {
        this.categories = data;
      },
      (err:any) => console.error(err)
    );
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/produits-list']);
  }

}
