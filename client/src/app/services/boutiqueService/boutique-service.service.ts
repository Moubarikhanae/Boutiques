import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Boutique } from 'src/app/models/boutique';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BoutiqueServiceService {

  private apiServerUrl = environment.apiURl
  constructor(private httpClient : HttpClient, private rooter : Router ) { }

  getAllBoutiques(): Observable <Boutique[]> {
    return this.httpClient.get<Boutique[]>(`${this.apiServerUrl}/boutiques/all`);
  }
  getBoutiqueById(id : number) : Observable <Boutique>{
    return this.httpClient.get<Boutique>(`${this.apiServerUrl}/boutiques/find` + id);

  }
  addBoutique(nom : string) :Observable <Boutique>{
    let boutique = {
      nom : nom
    }
    return this.httpClient.post<Boutique>(`${this.apiServerUrl}/boutique/add`, boutique);
  }
  deleteBoutiqueById(id : number) : Observable<void>{
    return this.httpClient.delete<void>(`${this.apiServerUrl}/boutique/delete/${id}`);

  }
  updateBoutique(id : number, description: string) : Observable<Boutique> {
    let boutique = {
      id : id
      
    }
    return this.httpClient.patch<Boutique>(`${this.apiServerUrl}/boutique/update`, boutique);
  }
}
