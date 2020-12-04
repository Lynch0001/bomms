import {Component, Input, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RestService } from './rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BookInCart} from './BookInCart';
import {ShareCartService} from './share-cart.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{


  booksInCart: BookInCart[];

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router, private cart: ShareCartService) {
    this.cart.booksInCart.subscribe(result => {
      console.log('AppComp - cart', result);
      this.booksInCart = result;
    });
  }

  ngOnInit() {

  }

}
