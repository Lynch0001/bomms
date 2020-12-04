import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BookInCart} from '../BookInCart';
import {ShareCartService} from '../share-cart.service';


@Component({
  selector: 'app-display-book',
  templateUrl: './display-book.component.html',
  styleUrls: ['./display-book.component.css']
})
export class DisplayBookComponent implements OnInit {

  books: any[];
  bookData: any;
  bookCartData: any;
  @Input() book: any;

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router, private cart: ShareCartService) {
    this.cart.booksInCart.subscribe(result => {
      console.log('Display - cart', result);
      this.books = result;
    });
}

  ngOnInit(): void {
  }

  showBookDetail(book): void {
    console.log('Catalog - Review Cart method: ', book);
    this.router.navigate(['book'], {state: {data: book}});
  }


}
