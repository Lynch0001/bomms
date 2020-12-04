import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Order} from './Order';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient ) { }

  zuulEndpoint = 'http://localhost:9090/';
  orderEndpoint = 'http://localhost:8028/api/';
  booksEndpoint = 'http://localhost:8027/';
  catalogEndpoint = 'http://localhost:8029/api/catalog';
  custEndpoint = 'http://localhost:8026/api/';
  storeEndpoint = 'http://localhost:8026/api/';

  httpOptions = {headers: new HttpHeaders(
      {'content-type': 'application/json',
        'Access-Control-Allow-Origin': 'http://localhost:4200',
      Vary: '*'}
    )};



private extractData(res: Response){
  const body = res;
  return body || {};
}

  getCatalog(): Observable<any> {
    return this.http.get(this.zuulEndpoint + 'api/catalog', this.httpOptions).pipe(
      map(this.extractData)
    );
  }

getBookData(isbn: number): Observable<any> {
  return this.http.get(this.zuulEndpoint + 'api/books/' + isbn, this.httpOptions).pipe(
    map(this.extractData)
  );
}

  getCustomerData(id: number): Observable<any> {
    console.log('Rest-Get Customer data for id: ', id);
    return this.http.get(this.zuulEndpoint + 'api/customers/' + id, this.httpOptions).pipe(
      map(this.extractData)
    );
  }

  postNewOrder(newOrder: Order): Observable<any>{
  console.log('Rest service posting new order: ', newOrder);
  return this.http.post<any>(this.zuulEndpoint + 'api/bookorders', JSON.stringify(newOrder), this.httpOptions).pipe(
    map(this.extractData)
  );
  }
}
