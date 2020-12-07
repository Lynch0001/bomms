import {Injectable, Output} from '@angular/core';
import {BookInCart} from './BookInCart';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShareCartService {

  cartDto: BookInCart[] = [];
  private booksInCartSource = new BehaviorSubject<BookInCart[]>([]);
  public booksInCart = this.booksInCartSource.asObservable();

  addBookToCart(book: any): any{
    console.log('Adding book to cart');
    this.cartDto.push(book);
    this.booksInCartSource.next(this.cartDto);
    console.log('cart after add: ', this.booksInCartSource.getValue());
  }

  clearCart(): any{
    console.log('Clearing cart');
    this.booksInCartSource.next([]);
    this.cartDto = [];
    console.log('cart after clear: ', this.booksInCartSource.value.length);
  }
}
