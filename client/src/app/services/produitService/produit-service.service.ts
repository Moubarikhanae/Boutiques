import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

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
  addProduit(produit : Produit) : Observable <Produit> {
   
    return this.httpClient.post<Produit>(`${this.apiServerUrl}/produit/add`, produit)
  }
  updateAllProduit(produit : Produit) : Observable <Produit> {
    return this.httpClient.put<Produit>(`${this.apiServerUrl}/produits/update`, produit)
  }
  deleteProduit(produitId : number) : Observable <void>{
    return this.httpClient.delete<void>(`${this.apiServerUrl}/produit/delete/${produitId}`)

  }
}
