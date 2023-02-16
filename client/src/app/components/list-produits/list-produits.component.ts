import { Component, OnInit } from '@angular/core';
import { ParamMap, Router } from '@angular/router';
import { ColDef, IDateFilterParams } from 'ag-grid-community';
import { Observable } from 'rxjs';
import { Produit } from 'src/app/models/produit';
import { ProduitServiceService } from 'src/app/services/produitService/produit-service.service';
import { ButtonCellRendererComponent } from '../button-cell-renderer/button-cell-renderer.component';

@Component({
  selector: 'app-list-produits',
  templateUrl: './list-produits.component.html',
  styleUrls: ['./list-produits.component.css']
})
export class ListProduitsComponent implements OnInit {

  produits: Observable<Produit[]>;
  rowData: Produit[];

  constructor(private produitService: ProduitServiceService,
    private route: Router, private router: Router) { }
    
    public defaultColDef: ColDef = {
      flex: 1,
      minWidth: 150,
      filter: true,
      resizable: true,
    };
  ngOnInit(): void {
   this.reloadData();
  }

  reloadData(){
    this.produitService.getProduitsList().subscribe(
      {
        next: (res:any) => {
          this.rowData = res;
        },
        error: (err:any) => {
          console.log("error");
        }
      }
    );
  }

 
  columnDefs: ColDef[] = [
    { field: 'nom', sortable: true,
    resizable: true
    },
    { field: 'description', sortable: true,
    resizable: true 
    },
    /*{ field: 'prix',
    resizable: true 
    },*/
    {
      field: 'Actions',
      resizable: true,
      cellRenderer: ButtonCellRendererComponent,
      cellRendererParams: {
        clicked: (params: any) => this.deleteProduit(params),
        onUpdate: (params: any) => this.updateProduit(params),
        onDetails: (params: any) => this.datailsProduit(params)

      },
    }
];
deleteProduit(params: any){
  this.produitService.deleteProduit(params)
  .subscribe(
    (data: any) => {
      this.reloadData();
    },
    (error: any) => console.log(error));
    }

 updateProduit(params: any) {
    this.router.navigate(['update-produit', params]);
  }

  datailsProduit(id: number){
    this.router.navigate(['details-produit', id]);
  }
  
}
var filterParams: IDateFilterParams = {
  comparator: (filterLocalDateAtMidnight: Date, cellValue: string) => {
    var dateAsString = cellValue;
    if (dateAsString == null) return -1;
    var dateParts = dateAsString.split('/');
    var cellDate = new Date(
      Number(dateParts[2]),
      Number(dateParts[1]) - 1,
      Number(dateParts[0])
    );
    if (filterLocalDateAtMidnight.getTime() === cellDate.getTime()) {
      return 0;
    }
    if (cellDate < filterLocalDateAtMidnight) {
      return -1;
    }
    if (cellDate > filterLocalDateAtMidnight) {
      return 1;
    }
    return 0;
  },
  browserDatePicker: true,
};