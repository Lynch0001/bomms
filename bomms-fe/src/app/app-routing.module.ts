import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {ShowCartComponent} from './show-cart/show-cart.component';
import {ShowCatalogComponent} from './show-catalog/show-catalog.component';
import {ShowBookDetailsComponent} from './show-book-details/show-book-details.component';

const routes: Routes = [];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot([
    {path: 'catalog', component: ShowCatalogComponent},
    {path: 'book', component: ShowBookDetailsComponent},
    {path: 'cart', component: ShowCartComponent}
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
