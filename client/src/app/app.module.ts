import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateCategorieComponent } from './components/create-categorie/create-categorie.component';
import { CategorieListComponent } from './components/categorie-list/categorie-list.component';
import { AgGridModule } from 'ag-grid-angular';
import { ButtonCellRendererComponent } from './components/button-cell-renderer/button-cell-renderer.component';
import { CategorieUpdateComponent } from './components/categorie-update/categorie-update.component';
import { CategorieDetailsComponent } from './components/categorie-details/categorie-details.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateCategorieComponent,
    CategorieListComponent,
    ButtonCellRendererComponent,
    CategorieUpdateComponent,
    CategorieDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    AgGridModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
