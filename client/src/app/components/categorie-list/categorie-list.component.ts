import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Categorie } from 'src/app/models/categorie';
import { CategorieServiceService } from 'src/app/services/categorieService/categorie-service.service';
import { AgGridAngular } from 'ag-grid-angular';
import { CellClickedEvent, ColDef, GridReadyEvent, IDateFilterParams } from 'ag-grid-community';
import { HttpClient } from '@angular/common/http';
import { ButtonCellRendererComponent } from '../button-cell-renderer/button-cell-renderer.component';

@Component({
  selector: 'app-categorie-list',
  templateUrl: './categorie-list.component.html',
  styleUrls: ['./categorie-list.component.css']
})
export class CategorieListComponent implements OnInit {

  categories: Observable<Categorie[]>;
  rowData: Categorie[];

  constructor(private categorieService:CategorieServiceService,
    private route: Router) { }
    
    public defaultColDef: ColDef = {
      flex: 1,
      minWidth: 150,
      filter: true,
    };
  ngOnInit(): void {
   this.reloadData();
  }

  reloadData(){
    this.categorieService.getCategoriesList().subscribe(
      {
        next: res => {
          this.rowData = res;
        },
        error: err => {
          console.log("error");
        }
      }
    );
  }

  columnDefs: ColDef[] = [
    { field: 'nom' },
    {
      field: 'Actions',
      cellRenderer: ButtonCellRendererComponent,
      cellRendererParams: {
        clicked: (params: any) => this.deleteCategorie(params)
      },
    }
];
deleteCategorie(params:any){
  this.categorieService.deleteCategorie(params)
  .subscribe(
    (data: any) => {
      this.reloadData();
    },
    (error: any) => console.log(error));
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