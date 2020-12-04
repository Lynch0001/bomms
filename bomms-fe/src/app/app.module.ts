import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {  HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { DisplayBookComponent } from './display-book/display-book.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ShowCartComponent } from './show-cart/show-cart.component';
import { ShowCatalogComponent } from './show-catalog/show-catalog.component';
import { ShowBookDetailsComponent } from './show-book-details/show-book-details.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    DisplayBookComponent,
    ShowCartComponent,
    ShowCatalogComponent,
    ShowBookDetailsComponent,
    HeaderComponent,
    FooterComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
