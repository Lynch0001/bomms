import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {RestService} from '../rest.service';
import {ShareCartService} from '../share-cart.service';
import {Order} from '../Order';
import {OrderItem} from '../OrderItem';
import {Address} from '../Address';
import {ShippingMethods} from '../shippingMethods';

@Component({
  selector: 'app-show-cart',
  templateUrl: './show-cart.component.html',
  styleUrls: ['./show-cart.component.css']
})

export class ShowCartComponent implements OnInit {

  orderSubmitSuccess = 'no';
  customerData: any;
  booksInCart: any;
  newOrder: Order;
  tempShippingMethod: ShippingMethods;
  tempBillingAddress: Address;
  tempShippingAddress: Address;
  checkoutForm: FormGroup;
  mockPaymentAuthCode: string = null;
  shippingMethods = ShippingMethods;
  keys = Object.keys;



  constructor(public rest: RestService,
              private route: ActivatedRoute,
              private router: Router,
              private cart: ShareCartService,
              private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.cart.booksInCart.subscribe(result => {
      this.booksInCart = result; });

    this.getCustomerData(1);

    this.checkoutForm = this.formBuilder.group({
      cname: '',
      cnum: '',
      exp: '',
      cvv: '',
      tempShippingMethod: ''
    });
    console.log('Shipping Method Enum: ', this.shippingMethods);
  }

  getCustomerData(id: number): any {
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
    cartTotal = cartTotal + this.getShippingCost(this.checkoutForm.get('tempShippingMethod').value);
    return [cartWithoutTax, cartTax, cartTotal];
  }

  getShippingCost(tempShippingMethod): number{
    console.log('Shipping cost based on Method: ', tempShippingMethod);
    let shippingCost = 0;
    switch (tempShippingMethod){
      case 'NextDayAir': {
        shippingCost = 9.99;
        break;
      }
      case 'SecondDayAir': {
        shippingCost = 4.35;
        break;
      }
      case 'Ground': {
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

  getMockPaymentAuthCode(): string{
    const auth = (Math.floor(Math.random() * 101) + 1) * 12345678;
    return 'Approved XXXX' + auth.toString();
  }

  setShippingAddress(address): void {
    console.log('Setting Shipping Address to: ', address);
    this.tempShippingAddress = new Address();
    this.tempShippingAddress.set_name(this.customerData.firstName + ' ' + this.customerData.lastName);
    this.tempShippingAddress.set_street(address.street);
    this.tempShippingAddress.set_city(address.city);
    this.tempShippingAddress.set_state(address.state);
    this.tempShippingAddress.set_zip(address.zip);
    console.log('Temp Shipping Address set to: ', this.tempShippingAddress);
  }

  submitOrder(): any{
    // Todo: check valid payment auth code before proceeding
    console.log('CheckoutForm Value: ', this.checkoutForm.value);
    const newOrder = new Order();
    newOrder.set_custid(this.customerData.custId);
    console.log('NewOrder CustomerData: ', this.customerData.custId);
    console.log('NewOrder Custid: ', newOrder.get_custid());
    newOrder.set_orderDate(new Date());
    newOrder.set_shippingMethod(this.checkoutForm.get('tempShippingMethod').value);
    newOrder.set_verificationEmail(this.customerData.email);
    console.log('NewOrder Shipping Address: ', this.tempShippingAddress);
    newOrder.set_shippingAddress(this.tempShippingAddress);
    newOrder.set_mockPaymentAuthCode(this.getMockPaymentAuthCode());
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
