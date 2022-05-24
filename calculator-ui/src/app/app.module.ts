import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {CalculateComponent} from './componets/calculate/calculate.component';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";
import { ExpressionComponent } from './componets/expression/expression.component';
import { ArgumentComponent } from './componets/argument/argument.component';
import { MaterialComponent } from './componets/material/material.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculateComponent,
    ExpressionComponent,
    ArgumentComponent,
    MaterialComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
