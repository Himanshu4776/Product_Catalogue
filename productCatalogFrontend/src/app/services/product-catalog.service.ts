import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Product } from '../model/product';
import { User } from '../model/user';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { Newuser } from '../model/newuser';
import { error } from '@angular/compiler/src/util';

@Injectable({
  providedIn: 'root'
})
export class ProductCatalogService {
  productCode:any;
  serviceResponse:any;

  errorMsg:string = ''
  findUser:string = ''

  loginUrl:string = 'http://localhost:8080/api/users/login';
  productUrl:string = 'http://localhost:8080/api/products';
  registerUrl:string = 'http://localhost:8080/api/users'
  servicabilityUrl:string = 'http://localhost:8080/api/products/servicability'
  searchUrl:string = 'http://localhost:8080/api/products/search'

  searchedProducts:any;
  emptyMessage:string = ''

  minvalue:any;
  maxvalue:any;

  checkVal:number = 0;

  constructor(private http:HttpClient,private router:Router) { }

  authentication(user:User) {
    return this.http.post<any>(`${this.loginUrl}`,user);
  }

  // loginUser(user:User):Observable<any> {
  //   console.log(user);
  //   // localStorage.setItem("currentuser",user.name);
  //   return this.http.post<any>(`${this.loginUrl}`,user).pipe(
  //     map(user => {
  //       localStorage.setItem('currentUser',user);
  //       console.warn("login sucess");
        
  //       return user;
  //     })
  //   );
  // }

  isLoggedIn() {
    if(localStorage.getItem('currentUser')) {
      return true;
    }
    return false;
  }

  register(data:any) {
    // if(this.http.get(`${this.findUser}`,data.username)){
    //   return null;
    // }
    // if(this.http.post(`${this.registerUrl}`,data)) {
    //   return this.http.post(`${this.registerUrl}`,data);
    // }
    // else {
    //   this.errorMsg = 'User already have an account';
    // }
    // return this.errorMsg;
    return this.http.post(`${this.registerUrl}`,data);
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }

  productInfo(code:any) {
    return this.http.get(`${this.productUrl}/${this.productCode}`);
  }

  productslist() {
    return this.http.get(`${this.productUrl}`);
  }

  SearchProduct(data:any) {
    console.warn("Results triggered");
    return this.searchedProducts = this.http.post<any>(`${this.searchUrl}`,data);
    
  }

  errorHandler(error:HttpErrorResponse){
    return throwError(error.error.message||'server error'); 
  }

  checkService() {
    return this.http.get(`${this.servicabilityUrl}/${this.checkVal}`);
  }
}
