import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

const AUTH_API = environment.apiURl + "/api/categories";
@Injectable({
  providedIn: 'root'
})
export class CategorieServiceService {
  

  constructor(private http: HttpClient) { }
  
  getCategoriesList(): Observable<any> {
    return this.http.get(`${AUTH_API}`);
  }

  deleteCategorie(id: number): Observable<any> {
    return this.http.delete(`${AUTH_API}/${id}`, { responseType: 'text' });
  }
}
