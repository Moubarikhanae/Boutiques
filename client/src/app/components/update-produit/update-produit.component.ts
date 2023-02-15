import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { Produit } from 'src/app/models/produit';
import { CategorieServiceService } from 'src/app/services/categorieService/categorie-service.service';
import { ProduitServiceService } from 'src/app/services/produitService/produit-service.service';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styleUrls: ['./update-produit.component.css']
})
export class UpdateProduitComponent implements OnInit {

  id: number;
  produit: Produit;
  submitted = false;
  errorMessage: string;  
  categories: Categorie[] = [];
  
  
  constructor(private route: ActivatedRoute,private router: Router, 
    private produitService: ProduitServiceService, private categorieService:CategorieServiceService) { }

  ngOnInit(): void {
    this.produit = new Produit();
    this.id = this.route.snapshot.params['id'];
    
    this.produitService.getProduit(this.id)
    .subscribe((data:any)=> this.produit = data,
    (error:any)=> console.log(error));
    
    this.categorieService.getCategoriesList().toPromise().then(
      (data:any) => {
        this.categories = data;
        this.categories.forEach(x=>{
          if (this.produit.categorieSet.find(i=> i.id==x.id)) {
          x.selectionne = true;
        }});
        
      },
      (err:any) => console.error(err)
    );

    this.categories.forEach(x=>{
      console.log("ici")
      if (this.produit.categorieSet.indexOf(x)>=0) {
        
      x.selectionne = true;
    }});
  }

  updateProduit() {
    this.produitService.updateProduit(this.id, this.produit)
    .subscribe((data:any)=> 
    {this.produit= new Produit();
      this.gotoList();
    },(error:any)=> {
      this.errorMessage = error.error.message;
      console.log(error)
    }
    )
  }
 
  onSubmit() {
    this.submitted = true;
    this.updateProduit();    
  }

  gotoList() {
    this.router.navigate(['/produits-list']);
  }


}
