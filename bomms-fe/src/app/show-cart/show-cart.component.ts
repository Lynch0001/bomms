import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {RestService} from '../rest.service';
import {ShareCartService} from '../share-cart.service';
import {Order} from '../Order';
import {OrderItem} from '../OrderItem';
import {Address} from '../Address';

@Component({
  selector: 'app-show-cart',
  templateUrl: './show-cart.component.html',
  styleUrls: ['./show-cart.component.css']
})



export class ShowCartComponent implements OnInit {

  orderSubmitSuccess = 'no';
  customerData: any;
  booksInCart;
  newOrder: Order;
  tempShippingMethod: any;
  tempBillingAddress: Address;
  tempShippingAddress: Address;
  private checkoutForm: FormGroup;


  constructor(public rest: RestService,
              private route: ActivatedRoute,
              private router: Router,
              private cart: ShareCartService,
              private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.cart.booksInCart.subscribe(result => {
      this.booksInCart = result;
      console.log('Show cart Init - Books in Cart: ', this.booksInCart);

    });
    this.getCustomerData(1);
    this.checkoutForm = this.formBuilder.group({
      cname: '',
      cnum: '',
      exp: '',
      cvv: '',
      shippingmethod: ''
    });
  }

  getCustomerData(id: number): void {
    console.log('Cart component get customer data for customer id: ', id);
    this.rest.getCustomerData(id).subscribe((data: {}) => {
      this.customerData = data;
      console.log('Cart customer data: ', this.customerData);
    });
  }

  getCartCost(): number[]{
    let cartWithoutTax = 0;
    let cartTotal = 0;
    let cartTax = 0;
    const taxRate = 0.06;
    for (const book of this.booksInCart){
      cartWithoutTax = cartWithoutTax + (book.price * book.qty);
      cartTotal = cartTotal + (book.price * book.qty * (1 + taxRate));
    }
    cartTax = cartWithoutTax * taxRate;
    cartTotal = cartTotal + this.getShippingCost(this.tempShippingMethod);
    return [cartWithoutTax, cartTax, cartTotal];
  }

  getShippingCost(tempShippingMethod): number{
    let shippingCost = 0;
    switch (tempShippingMethod){
      case 'Next Day Air': {
        shippingCost = 9.99;
        break;
      }
      case 'Second Day Air': {
        shippingCost = 4.35;
        break;
      }
      case 'Standard Ground': {
        shippingCost = 2.15;
        break;
      }
      default: {
        shippingCost = 0.00;
        break;
      }
    }
    return shippingCost;
  }

  submitOrder(): any{
    console.log('CheckoutForm Value: ', this.checkoutForm.value);
    const newOrder = new Order();
    newOrder.set_custid(this.customerData.custId);
    console.log('NewOrder CustomerData: ', this.customerData.custId);
    console.log('NewOrder Custid: ', newOrder.get_custid());
    newOrder.set_orderDate(new Date());
    newOrder.set_shippingMethod(this.tempShippingMethod);
    newOrder.set_billingAddress(this.tempBillingAddress);
    newOrder.set_shippingAddress(this.tempShippingAddress);
    newOrder.bookItems = [];
    console.log('NewOrder Date: ', newOrder.orderDate);
    for (const bookInCart of this.booksInCart){
      const tempOrderItem: OrderItem = new OrderItem();
      tempOrderItem.set_isbn(bookInCart.get_isbn());
      tempOrderItem.set_price(bookInCart.get_price());
      tempOrderItem.set_quantity(bookInCart.get_qty());
      newOrder.bookItems.push(tempOrderItem);
    }
    console.log('New Order posting to order-service: ', newOrder);
    this.rest.postNewOrder(newOrder).subscribe(res => {
      console.log('Added new Order without errors: ', res);
      this.cart.clearCart();
      console.log('booksInCart: ', this.booksInCart);
      this.orderSubmitSuccess = 'yes';
      this.checkoutForm.reset();
      this.router.navigate(['cart']);
      }, (err) => {
      console.log('Error Adding Order: ', err);
      this.router.navigate(['cart']);
    });
  }

}
