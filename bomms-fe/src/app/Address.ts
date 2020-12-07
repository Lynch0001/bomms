export class Address {
  private id: number = null;
  private name: string;
  private street: string;
  private city: string;
  private state: string;
  private zip: string;
  private billing: boolean = false;
  private shipping: boolean = false;


  constructor() {
  }

  get_id(): number {
    return this.id;
  }

  set_id(value: number): void {
    this.id = value;
  }

  get_name(): string {
    return this.name;
  }

  set_name(value: string): void {
    this.name = value;
  }

  get_street(): string {
    return this.street;
  }

  set_street(value: string): void {
    this.street = value;
  }

  get_city(): string {
    return this.city;
  }

  set_city(value: string): void {
    this.city = value;
  }

  get_state(): string {
    return this.state;
  }

  set_state(value: string): void {
    this.state = value;
  }

  get_zip(): string {
    return this.zip;
  }

  set_zip(value: string): void {
    this.zip = value;
  }

  get_billing(): boolean {
    return this.billing;
  }

  set_billing(value: boolean): void {
    this.billing = value;
  }

  get_shipping(): boolean {
    return this.shipping;
  }

  set_shipping(value: boolean): void {
    this.shipping = value;
  }
}
