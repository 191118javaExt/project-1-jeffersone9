import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReimbursementComponent } from './component/reimbursement/reimbursement.component';
import { LoginComponent } from './component/login/login/login.component';
import { HomeComponent } from './component/home/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    ReimbursementComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
