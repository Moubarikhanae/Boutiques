import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from 'src/app/models/categorie';
import { CategorieServiceService } from 'src/app/services/categorieService/categorie-service.service';

@Component({
  selector: 'app-categorie-details',
  templateUrl: './categorie-details.component.html',
  styleUrls: ['./categorie-details.component.css']
})
export class CategorieDetailsComponent implements OnInit {

  id: number;
  categorie: Categorie;


  constructor(private route: ActivatedRoute,private router: Router,
    private categorieService: CategorieServiceService) { }

  ngOnInit(): void {
    this.categorie = new Categorie();
    
    this.id = this.route.snapshot.params['id'];

    this.categorieService.getCategorie(this.id)
    .subscribe(
      (data: any) => this.categorie = data,
      (error: any) => console.log(error)
    );

  }

  list(){
    this.router.navigate(['/categories-list']);
  }

}
