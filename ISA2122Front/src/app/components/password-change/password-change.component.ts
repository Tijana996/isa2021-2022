import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthentificationService, AuthResponseData } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-password-change',
  templateUrl: './password-change.component.html',
  styleUrls: ['./password-change.component.scss']
})
export class PasswordChangeComponent implements OnInit {
  isLoading = false;
  error: string = null;

  constructor(private authService: AuthentificationService, private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(form : NgForm){
    if (!form.valid) {
      return;
    }
    const password = form.value.password;
    const password2 = form.value.password2;

    if(password!=password2){
      this.error = "Lozinke se moraju poklapati";
      this.isLoading = false;
      return;
    }

    let authObs: Observable<AuthResponseData>;

    this.isLoading = true;

    this.authService.changePassword(password).subscribe( 
      result => {
        alert("Lozinka je promenjena!");
        this.router.navigate(['/home-page-admin']);
      },        
      err =>{
        console.log(err)
        this.error = err.message;
        this.isLoading = false;
      });

    form.reset();
  }

}
