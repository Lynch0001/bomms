import {Component, Input, OnInit} from '@angular/core';
import {RestService} from '../rest.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ShareCartService} from '../share-cart.service';
import {BookInCart} from '../BookInCart';

@Component({
  selector: 'app-show-book-details',
  templateUrl: './show-book-details.component.html',
  styleUrls: ['./show-book-details.component.css']
})
export class ShowBookDetailsComponent implements OnInit {

  booksInCart: any[];
  @Input() book: any;

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router, private cart: ShareCartService) {
  }

  ngOnInit(): void {
    this.book = history.state.data;
    console.log('BookDetail - Book on Init: ', this.book);
  }

  addToCart(): void {
    console.log('BookDetail - Add ISBN to cart: ', this.book.isbn13);
    const bookInCart = new BookInCart();
    bookInCart.setTitle(this.book.title);
    bookInCart.set_authors(this.book.authors);
    bookInCart.set_image(this.book.image);
    bookInCart.set_isbn(this.book.isbn13);
    bookInCart.set_qty(1);
    const convPriceToNumber = parseFloat(this.book.price.toString().substr(1));
    bookInCart.set_price(convPriceToNumber);
    this.cart.addBookToCart(bookInCart);
    this.router.navigate(['catalog']);
  }

}
