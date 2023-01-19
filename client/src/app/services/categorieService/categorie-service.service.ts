import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Categorie } from 'src/app/models/categorie';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategorieServiceService {
  private apiServerUrl = environment.apiURl
  constructor(private httpClient : HttpClient, private rooter : Router ) { }

  createCategory( nom : string) :Observable <Categorie>{
    let categorie = {
      nom : nom,
     
    }
    return this.httpClient.post<Categorie>(`${this.apiServerUrl}/categorie/add`, categorie);
  }
  updateCategory( nom: string) :Observable<Categorie> {
    let categorie = {
    
      nom : nom,
    }
    return this.httpClient.patch<Categorie>(`${this.apiServerUrl}/categorie/update`, categorie)
  }
  deleteCategory(id : number) :Observable<Categorie>{
    return this.httpClient.delete<Categorie>(`${this.apiServerUrl}/delete/` +id);
  }

}
