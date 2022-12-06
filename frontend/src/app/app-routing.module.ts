import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsersGuardService as guard} from './guards/users-guard.service';
import { IndexComponent } from './index/index.component';
import { CrearCuentaComponent } from './persona/crear-cuenta/crear-cuenta.component';
import { IniciarSesionComponent } from './persona/iniciar-sesion/iniciar-sesion.component';


const routes: Routes = [
  { path: '', component: IndexComponent },
  { path: 'home', component: IndexComponent },
  { path: 'login', component: IniciarSesionComponent },
  { path: 'registro', component: CrearCuentaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
