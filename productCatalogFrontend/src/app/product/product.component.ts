import { Component, OnInit } from '@angular/core';
import { ProductCatalogService } from '../services/product-catalog.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  constructor(private productCatalog: ProductCatalogService) {
    productCatalog.productInfo(this.code).subscribe((data) => {
      this.product = data;
    });
  }

  product: any;
  code: any;

  ngOnInit(): void {
    this.code = this.productCatalog.productCode;
  }

  available: any = 2;
  pincodelist: any[] = ['1002', '1001', '1004', 1010];
  checkVal: string = '';

  servicability(box: string) {
    this.checkVal = box;
    for (let index = 0; index < this.pincodelist.length; index++) {
      if (this.checkVal == this.pincodelist[index]) {
        this.available = 1;
        break;
      } else {
        this.available = 0;
      }
    }
  }

  /// Servicability code
  // available: any = 2;
  // pincodelist: any[] = ['1002', '1001', '1004', 1010];
  // checkVal: string = '';
  // result: any;

  // servicability(box: any) {
  //   this.productCatalog.checkVal = +box;
  //   // Front end code -------------------->
  //   for (let index = 0; index < this.pincodelist.length; index++) {
  //     if (this.checkVal == this.pincodelist[index]) {
  //       this.available = 1;
  //       break;
  //     } else {
  //       this.available = 0;
  //     }
  //   }

  // }
  // Backend code ---------------------->
  // this.result = this.productCatalog.checkService().subscribe((Response) => {
  //   const valid = Response;

  //   console.warn('Response is ', Response);

  //   if (valid == true) {
  //     this.available = 1;
  //   } else {
  //     this.available = 0;
  //   }
  // });
}
