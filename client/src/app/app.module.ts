import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AcceuilComponent } from './components/acceuil/acceuil/acceuil.component';
import { BoutiqueComponent } from './components/boutique/boutique/boutique.component';
import { AjoutBoutiqueComponent } from './components/dialogs/ajoutBoutique/ajout-boutique/ajout-boutique.component';
import { AjoutCategorieComponent } from './components/dialogs/ajoutCategorie/ajout-categorie/ajout-categorie.component';
import { AjoutProduitComponent } from './components/dialogs/ajoutProduit/ajout-produit/ajout-produit.component';
import {MatFormFieldModule} from '@angular/material/form-field';

@NgModule({
  declarations: [
    AppComponent,
    AcceuilComponent,
    BoutiqueComponent,
    AjoutBoutiqueComponent,
    AjoutProduitComponent,
    AjoutCategorieComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatFormFieldModule,

  ],


  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
