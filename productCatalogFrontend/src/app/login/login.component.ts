import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { ProductCatalogService } from '../services/product-catalog.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  alertError: any = '';
  errorMsg: string = '';
  constructor(
    private router: Router,
    private productCatalog: ProductCatalogService
  ) {}

  user: User = new User();
  valid = false;

  ngOnInit(): void {}

  closeAlertError() {
    this.alertError = false;
  }

  createError() {
    this.alertError = true;
    this.errorMsg = 'Server Error';
  }

  onlogin() {
    this.productCatalog.authentication(this.user).subscribe((Response) => {
      const valid = Response;
      console.log('Authentication response is ', Response);
      if (valid == true) {
        localStorage.setItem('currentUser', Response);
        this.router.navigate(['/productgrid']);
      } else {
        this.alertError = true;
        this.errorMsg = 'Authentication Unsuccessfull';
      }
    });
  }
}
