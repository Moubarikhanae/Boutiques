import { Component, OnInit } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { ICellRendererParams } from 'ag-grid-community';

@Component({
  selector: 'app-button-cell-rendrer-produit',
  template: `
  <button class="btn btn-dark" (click)="btnClickedHandler($event)"><i class="bi bi-search"></i> Ajouter un produit </button>
`,
  styleUrls: ['./button-cell-rendrer-produit.component.css']
})
export class ButtonCellRendrerProduitComponent implements OnInit, ICellRendererAngularComp {

  refresh(params: ICellRendererParams<any, any>): boolean {
    throw new Error('Method not implemented.');
  }

  private params: any;

  ngOnInit(): void {
  }

  agInit(params: any): void {
    this.params = params;
  }

  btnClickedHandler(name: any) {
    this.params.clicked(this.params.node.data.id);
  }
  onEditClicked(params: any) {
    this.params.onUpdate(this.params.node.data.id);
  }
  onDetailsClicked(prams: any) {
    this.params.onDetails(this.params.node.data.id);
  }
}