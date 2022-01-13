import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageUserComponent } from './components/home-page-user/home-page-user.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { VikendicaProfilComponent } from './components/vikendica-profil/vikendica-profil.component';
import { VikendicePrikazComponent } from './components/vikendice-prikaz/vikendice-prikaz.component';

const routes: Routes = [
  { path: 'home-page-user', component : HomePageUserComponent },
  { path: 'login', component : LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'profile', component: UserProfileComponent },
  { path: 'vikendice', component: VikendicePrikazComponent },
  { path: 'vikendica/:id', component : VikendicaProfilComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
