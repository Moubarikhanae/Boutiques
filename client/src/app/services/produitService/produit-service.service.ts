import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Categorie } from 'src/app/models/categorie';


@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {
  private apiServerUrl = environment.apiURl
  constructor(private httpClient: HttpClient, private router: Router) { }

  getAllProduit() : Observable <Produit[]>{
    return this.httpClient.get<Produit[]>(`${this.apiServerUrl}/produits/all`)

  }
  getProduitById(id : number) : Observable <Produit>{
    return this.httpClient.get<Produit>(`${this.apiServerUrl}/produit/find` + id)
  }
  addProduit(nom: string, description: string, categorie: Categorie, prix: number) : Observable <Produit> {
    let produit ={
      nom : nom,
      description: description,
      categorie :categorie,
      prix : prix
    }
   
    return this.httpClient.post<Produit>(`${this.apiServerUrl}/produit/add`, produit)
  }
  updateProduit(description: string, prix: number ) : Observable <Produit>{
    let produit = {
      description: description,
      prix: prix
    }
    return this.httpClient.patch<Produit>(`${this.apiServerUrl}/produit/update`, produit)
  }
  deleteProduit(produitId : number) : Observable <void>{
    return this.httpClient.delete<void>(`${this.apiServerUrl}/produit/delete/${produitId}`)

  }
}
