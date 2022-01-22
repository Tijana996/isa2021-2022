import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BrodPrikazComponent } from './components/brod-prikaz/brod-prikaz.component';
import { BrodProfilComponent } from './components/brod-profil/brod-profil.component';
import { BrzeRezervacijeComponent } from './components/brze-rezervacije/brze-rezervacije.component';
import { HomePageAdminComponent } from './components/home-page-admin/home-page-admin.component';
import { HomePageUserComponent } from './components/home-page-user/home-page-user.component';
import { IstruktorProfilComponent } from './components/istruktor-profil/istruktor-profil.component';
import { IstruktoriComponent } from './components/istruktori/istruktori.component';
import { LoginComponent } from './components/login/login.component';
import { PasswordChangeComponent } from './components/password-change/password-change.component';
import { RegisterAdminComponent } from './components/register-admin/register-admin.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { RezervacijeComponent } from './components/rezervacije/rezervacije.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { VikendicaProfilComponent } from './components/vikendica-profil/vikendica-profil.component';
import { VikendicaRezervacijaComponent } from './components/vikendica-rezervacija/vikendica-rezervacija.component';
import { VikendicePrikazComponent } from './components/vikendice-prikaz/vikendice-prikaz.component';
import { ZahteviRegistracijaPrikazComponent } from './components/zahtevi-registracija-prikaz/zahtevi-registracija-prikaz.component';
import { ZalbePrikazComponent } from './components/zalbe-prikaz/zalbe-prikaz.component';

const routes: Routes = [
  { path: 'home-page-user', component : HomePageUserComponent },
  { path: 'home-page-admin', component : HomePageAdminComponent },
  { path: 'password-change-admin', component : PasswordChangeComponent },
  { path: 'login', component : LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'register-admin', component: RegisterAdminComponent },
  { path: 'profile', component: UserProfileComponent },
  { path: 'vikendice', component: VikendicePrikazComponent },
  { path: 'vikendica/:id', component : VikendicaProfilComponent},
  { path: 'rezervacija/:comp/:id/:datum', component: VikendicaRezervacijaComponent },
  { path: 'rezervacije', component: RezervacijeComponent },
  { path: 'brzerezervacije', component: BrzeRezervacijeComponent },
  { path: 'zahtevi', component: ZahteviRegistracijaPrikazComponent },
  { path: 'zalbe', component: ZalbePrikazComponent },
  { path: 'brodovi', component: BrodPrikazComponent},
  { path: 'brod/:id', component: BrodProfilComponent},
  { path: 'instruktori', component: IstruktoriComponent},
  { path: 'instruktor/:id', component:IstruktorProfilComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
