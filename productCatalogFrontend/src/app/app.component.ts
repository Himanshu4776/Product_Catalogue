import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductCatalogService } from './services/product-catalog.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'productCatalogFrontend';
  heading = 'Product Catalog';

  constructor(private router:Router,private productCatalogService: ProductCatalogService) {}

  logoutUser() {
    return this.productCatalogService.logout();
  }

  logcheck() {
    return this.productCatalogService.isLoggedIn();
  }

  goToProductSearch() {
    this.router.navigate(['/productgrid']);
  }
}
