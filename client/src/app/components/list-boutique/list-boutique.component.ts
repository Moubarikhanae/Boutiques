import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ColDef, IDateFilterParams } from 'ag-grid-community';
import { Observable } from 'rxjs';
import { Boutique } from 'src/app/models/boutique';
import { BoutiqueServiceService } from 'src/app/services/boutiqueService/boutique-service.service';
import { ButtonCellRendererComponent } from '../button-cell-renderer/button-cell-renderer.component';

@Component({
  selector: 'app-list-boutique',
  templateUrl: './list-boutique.component.html',
  styleUrls: ['./list-boutique.component.css']
})
export class ListBoutiqueComponent implements OnInit {

  boutiques: Observable<Boutique[]>;
  
   rowData: Boutique[];

   public defaultColDef: ColDef = {
      flex: 1,
      minWidth: 20,
      filter: true,
      resizable: true,
    };

  constructor(private boutiqueService: BoutiqueServiceService,
    private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
   this.boutiqueService.getBoutiquesList().subscribe(
    {
        next: res => {
          this.rowData = res;
          this.rowData.forEach(p => {
            p.nombreProduits=p.produitSet.length;
        })
        },
        error: err => {
          console.log("error");
        }
    }
   )
  }

  columnDefs: ColDef[] = [
    { field: 'nom' , sortable: true,},
    { field: 'dateCreation',
    sortable: true,
    filter: 'agDateColumnFilter',
    filterParams: dateComparator,
    valueFormatter: (params) => {
      return params.value ? new Date(params.value).toLocaleDateString('fr-FR', {day: '2-digit', month: '2-digit', year: 'numeric'}) : '';
    }},
    { field: 'conge', sortable: true,  valueFormatter: (params) => {
      return params.value == true ?  'En congé' : 'En service';
    }},
    {
      field: 'nombreProduits',
      sortable: true,
    },
    {
      field: 'Actions',
      cellRenderer: ButtonCellRendererComponent,
      cellRendererParams: {
      clicked: (params: any) => this.deleteBoutique(params),
       //  onUpdate: (params: any) => this.updateCategorie(params),
       // onDetails: (params: any) => this.datailsCategorie(params)

      },
    }
];

deleteBoutique(params: any){
  this.boutiqueService.deleteBoutique(params)
  .subscribe(
    (data: any) => {
      this.reloadData();
    },
    (error: any) => console.log(error));
    }

}

const dateComparator = (filterLocalDateAtMidnight: Date, cellValue: any): number => {
  let cellDate: Date;

  // Vérifier si la valeur de la cellule est une chaîne de caractères
  if (typeof cellValue === 'string') {
    // Convertir la chaîne de caractères en objet Date
    const [day, month, year] = cellValue.split('/');
    cellDate = new Date(Number(year), Number(month) - 1, Number(day));
  } else if (cellValue instanceof Date) {
    // Si la valeur de la cellule est un objet Date, utiliser cette valeur
    cellDate = cellValue;
  } else {
    // Sinon, la valeur n'est pas valide pour un comparateur de date
    return 0;
  }

  // Comparer les dates
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
};
