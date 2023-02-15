import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/models/produit';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

const PRODUIT_API = environment.apiURl + "/api/produits";
@Injectable({
  providedIn: 'root'
})
export class ProduitServiceService {

  constructor(private httpClient: HttpClient, private router: Router) { }

  getProduitsList() : Observable <Produit[]>{
    return this.httpClient.get<any>(`${PRODUIT_API}`)

  }
 
}
