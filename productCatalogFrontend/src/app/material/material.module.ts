import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule}from '@angular/material/button';
import {MatIconModule }from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatDialogModule,
   MatButtonModule,
   MatIconModule,
   MatTableModule
  ],
  exports:[
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule
  ]
})
export class MaterialModule { }
