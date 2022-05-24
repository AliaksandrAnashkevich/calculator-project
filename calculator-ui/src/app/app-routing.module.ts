import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CalculateComponent} from "./componets/calculate/calculate.component";

const routes: Routes = [
  { path: '', redirectTo: 'calculation', pathMatch: 'full' },
  { path: 'calculation', component: CalculateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
