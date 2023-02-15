import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { ProduitServiceService } from 'src/app/services/produitService/produit-service.service';

@Component({
  selector: 'app-produit-details',
  templateUrl: './produit-details.component.html',
  styleUrls: ['./produit-details.component.css']
})
export class ProduitDetailsComponent implements OnInit {

  id:number;
  produit: Produit;

  constructor(private route: ActivatedRoute,private router: Router,
    private produitService: ProduitServiceService) { }

  ngOnInit(): void {
    this.produit = new Produit();

    this.id = this.route.snapshot.params['id'];

    this.produitService.getProduit(this.id)
    .subscribe((data:any)=> this.produit = data,
    (error:any)=> console.log(error));

  }

  list(){
    this.router.navigate(['produits-list']);
  }

}
