import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Boutique } from 'src/app/models/boutique';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const BOUTIQUE_API = environment.apiURl+"/api/boutiques";

@Injectable({
  providedIn: 'root'
})
export class BoutiqueServiceService {

  constructor(private httpClient : HttpClient ) { }

  getBoutique(id: number): Observable<any> {
    return this.httpClient.get(`${BOUTIQUE_API}/${id}`);
  }

  createBoutique(boutique: Object): Observable<Object> {
    return this.httpClient.post(`${BOUTIQUE_API}/save-boutique`, boutique);
  }

  updateBoutique(id: number, value: any): Observable<Object> {
    return this.httpClient.put(`${BOUTIQUE_API}/${id}`, value);
  }

  deleteBoutique(id: number): Observable<any> {
    return this.httpClient.delete(`${BOUTIQUE_API}/${id}`, { responseType: 'text' });
  }

  getBoutiquesList(): Observable<any> {
    return this.httpClient.get(`${BOUTIQUE_API}`);
  }
}
