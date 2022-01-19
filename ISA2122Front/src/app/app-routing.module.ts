import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BrzeRezervacijeComponent } from './components/brze-rezervacije/brze-rezervacije.component';
import { HomePageAdminComponent } from './components/home-page-admin/home-page-admin.component';
import { HomePageUserComponent } from './components/home-page-user/home-page-user.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterAdminComponent } from './components/register-admin/register-admin.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { RezervacijeComponent } from './components/rezervacije/rezervacije.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { VikendicaProfilComponent } from './components/vikendica-profil/vikendica-profil.component';
import { VikendicaRezervacijaComponent } from './components/vikendica-rezervacija/vikendica-rezervacija.component';
import { VikendicePrikazComponent } from './components/vikendice-prikaz/vikendice-prikaz.component';
import { ZahteviRegistracijaPrikazComponent } from './components/zahtevi-registracija-prikaz/zahtevi-registracija-prikaz.component';

const routes: Routes = [
  { path: 'home-page-user', component : HomePageUserComponent },
  { path: 'home-page-admin', component : HomePageAdminComponent },
  { path: 'login', component : LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'register-admin', component: RegisterAdminComponent },
  { path: 'profile', component: UserProfileComponent },
  { path: 'vikendice', component: VikendicePrikazComponent },
  { path: 'vikendica/:id', component : VikendicaProfilComponent},
  { path: 'rezervacija/:id/:datum', component: VikendicaRezervacijaComponent },
  { path: 'rezervacije', component: RezervacijeComponent },
  { path: 'brzerezervacije', component: BrzeRezervacijeComponent },
  { path: 'zahtevi', component: ZahteviRegistracijaPrikazComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
