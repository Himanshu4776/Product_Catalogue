import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductCatalogService } from '../services/product-catalog.service';

@Component({
  selector: 'app-product-grid',
  templateUrl: './product-grid.component.html',
  styleUrls: ['./product-grid.component.css'],
})
export class ProductGridComponent implements OnInit {
  products: any;
  searchFilter: any;

  searchList: any;

  constructor(
    private router: Router,
    private productCatalog: ProductCatalogService
  ) {
    productCatalog.productslist().subscribe((data) => {
      this.products = data;
    });
  }

  ngOnInit(): void {}

  forwardProduct(route: string, code: any) {
    this.productCatalog.productCode = code;
    this.router.navigateByUrl(`/${route}`);
  }

  filter(minval: any, maxval: any) {
    this.productCatalog.minvalue = minval;
    this.productCatalog.maxvalue = maxval;
  }

  searchProduct(data: any) {
    this.searchFilter = data;
    this.searchResults();
  }

  searchResults() {
    return this.productCatalog
      .SearchProduct(this.searchFilter)
      .subscribe((data) => {
        this.products = data;
      });
  }
}
