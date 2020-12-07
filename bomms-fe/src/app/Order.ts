import {OrderItem} from './OrderItem';
import {Address} from './Address';
import {ShippingMethods} from './shippingMethods';

export class Order {
  id: number;
  custId: string;
  orderDate: Date;
  bookItems: OrderItem[];
  shippingAddress: Address;
  shippingMethod: ShippingMethods;
  verificationEmail: string;
  mockPaymentAuthCode: string;

  constructor() {
  }

  public get_id(): number {
    return this.id;
  }

  public set_id(id: number): void {
    this.id = id;
  }

  public get_custid(): string {
    return this.custId;
  }

  public set_custid(custId: string): void {
    console.log('setting Customer ID for new Order - CustId: ', custId);
    this.custId = custId;
  }

  public get_orderDate(): Date {
    return this.orderDate;
  }

  public set_orderDate(orderDate: Date): void {
    this.orderDate = orderDate;
  }

  public get_bookItems(): OrderItem[] {
    return this.bookItems;
  }

  public set_bookItems(bookItems: OrderItem[]): void {
    this.bookItems = bookItems;
  }

  get_shippingAddress(): any {
    return this.shippingAddress;
  }

  set_shippingAddress(value: any): any {
    this.shippingAddress = value;
  }

  get_shippingMethod(): ShippingMethods {
    return this.shippingMethod;
  }

  set_shippingMethod(value: any): any {
    console.log('Set Shipping Method for value: ', value);
    this.shippingMethod = value;
  }

  get_verificationEmail(): string {
    return this.verificationEmail;
  }

  set_verificationEmail(value: string): void {
    this.verificationEmail = value;
  }

  get_mockPaymentAuthCode(): string {
    return this.mockPaymentAuthCode;
  }

  set_mockPaymentAuthCode(value: string): void {
    this.mockPaymentAuthCode = value;
  }
}
