import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategorieListComponent } from './components/categorie-list/categorie-list.component';

const routes: Routes = [
  {path:"categories-list", component:CategorieListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
