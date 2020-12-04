import {Component, Input, OnInit, Output} from '@angular/core';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ShareCartService} from '../share-cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  booksInCartH;
  books: any;

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router, private cart: ShareCartService) {
  }

  ngOnInit(): void {
    this.cart.booksInCart.subscribe(result => {
      this.booksInCartH = result;
      console.log('Header - Constructor Cart: ', this.booksInCartH);
    });
  }

  reviewCart(): void{
    console.log('Catalog - Review Cart method: ', this.booksInCartH);
    this.router.navigate(['cart']);
  }

}
