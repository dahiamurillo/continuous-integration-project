import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IniciarSesionComponent } from './persona/iniciar-sesion/iniciar-sesion.component';
import { CrearCuentaComponent } from './persona/crear-cuenta/crear-cuenta.component';
import { MenuComponent } from './menu/menu.component';
import { IndexComponent } from './index/index.component';
import { interceporProvider } from './interceptors/users-interceptor.service';

//para consumar API y el formulario
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

//externos
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    IniciarSesionComponent,
    CrearCuentaComponent,
    MenuComponent,
    IndexComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [interceporProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
