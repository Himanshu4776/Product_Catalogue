import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductCatalogService } from '../services/product-catalog.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  alertError: any = false;
  errorMsg: string = '';

  constructor(
    private router: Router,
    private productCatalog: ProductCatalogService
  ) {}

  ngOnInit(): void {}

  register(data: any) {
    console.warn(data);
    if (data.password != data.cnfPassword) {
      this.createError('Passwords should be same');
      return;
    }
    console.warn('Check');

    return this.productCatalog.register(data).subscribe(() => {
      this.router.navigate(['/productgrid']);
    });
  }
  closeAlertError() {
    this.alertError = false;
  }

  createError(errorMsg: string) {
    this.alertError = true;
    this.errorMsg = errorMsg;
  }
}
