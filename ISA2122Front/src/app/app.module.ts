import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { HomePageUserComponent } from './components/home-page-user/home-page-user.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/login/login.component';
import { MatCardModule} from '@angular/material/card';
import {MatSortModule} from '@angular/material/sort';
import { AuthentificationService } from './services/authentification.service';
import { JwtUtilsService } from './services/jwt-utils.service';
import { TokenInterceptorService } from './services/token-interceptor.service';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { VikendicePrikazComponent } from './components/vikendice-prikaz/vikendice-prikaz.component';
import { BrodPrikazComponent } from './components/brod-prikaz/brod-prikaz.component';
import { BrodProfilComponent } from './components/brod-profil/brod-profil.component';
import { VikendicaProfilComponent } from './components/vikendica-profil/vikendica-profil.component';
import { VikendicaRezervacijaComponent } from './components/vikendica-rezervacija/vikendica-rezervacija.component';
import { RezervacijeComponent } from './components/rezervacije/rezervacije.component';
import { BrzeRezervacijeComponent } from './components/brze-rezervacije/brze-rezervacije.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomePageUserComponent,
    UserProfileComponent,
    VikendicePrikazComponent,
    BrodPrikazComponent,
    BrodProfilComponent,
    VikendicaProfilComponent,
    VikendicaRezervacijaComponent,
    RezervacijeComponent,
    BrzeRezervacijeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,    
    ReactiveFormsModule,
    MatCardModule,
    MatSortModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: JSON.parse(localStorage.getItem('currentUser') || '{"token":""}')?.token,
        allowedDomains: ["localhost:4200"],
      },
    })
  ],
  providers: [AuthentificationService,JwtUtilsService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }