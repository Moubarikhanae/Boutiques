import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Boutique } from 'src/app/models/boutique';
import { BoutiqueServiceService } from 'src/app/services/boutiqueService/boutique-service.service';

@Component({
  selector: 'app-details-boutique',
  templateUrl: './details-boutique.component.html',
  styleUrls: ['./details-boutique.component.css']
})
export class DetailsBoutiqueComponent implements OnInit {

  id: number;
  boutique: Boutique = new Boutique();
  
  constructor(private router: Router, 
    private boutiqueService: BoutiqueServiceService, private route: ActivatedRoute) { 
    }
  
    ngOnInit(): void {

      this.id = this.route.snapshot.params['id'];

      this.boutiqueService.getBoutique(this.id)
      .subscribe(
        data => {
            this.boutique = data;
        },
        error => console.log(error)
      );
    }
    
    list(){
      this.router.navigate(['/list-boutiques']);
    }
  

}
