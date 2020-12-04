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

  addBookToCart(book: any): void{
    this.cartDto.push(book);
    this.booksInCartSource.next(this.cartDto);
  }

  clearCart(): void{
    this.booksInCartSource.next([]);
    this.cartDto = [];
    console.log('cart after clear: ', this.booksInCartSource.value.length);
  }
}
