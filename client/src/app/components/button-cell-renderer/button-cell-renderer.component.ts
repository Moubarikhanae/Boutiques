import { Component, OnInit } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { ICellRendererParams } from 'ag-grid-community';

@Component({
  selector: 'app-button-cell-renderer',
  template: `
  <button class="btn btn-danger" (click)="btnClickedHandler($event)">Supprimer</button>
`,
  styleUrls: ['./button-cell-renderer.component.css']
})
export class ButtonCellRendererComponent implements OnInit, ICellRendererAngularComp {

  refresh(params: ICellRendererParams<any, any>): boolean {
    throw new Error('Method not implemented.');
  }

  private params: any;

  ngOnInit(): void {
  }

  agInit(params: any): void {
    this.params = params;
  }

  btnClickedHandler(name:any) {
    this.params.clicked(this.params.node.data.id);
  }
}
