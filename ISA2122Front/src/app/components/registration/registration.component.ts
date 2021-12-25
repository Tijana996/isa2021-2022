import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserReg } from 'src/app/models/userregister';
import { AuthentificationService } from 'src/app/services/authentification.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  user: UserReg;
  registrationForm: FormGroup;
  wrong: boolean;
  errorMessage: string;

  constructor(
    private fb: FormBuilder,
    private route : Router,
    private regService : AuthentificationService
  ) {
    this.wrong = false; 
    this.user = new UserReg();
    this.registrationForm = this.fb.group({
      'email':['',[Validators.required, Validators.email]],
      'password' : ['', Validators.required],
      'passwordc' : ['', Validators.required],
      'adresa' : ['', Validators.required],
      'drzava' : ['', Validators.required],
      'broj' : ['', Validators.required],
      'grad' : ['', Validators.required],
      'ime' : ['', Validators.required],
      'prezime' : ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  
  onSubmit(){
      var pass = this.registrationForm.controls['password'].value;
      var pass2 = this.registrationForm.controls['passwordc'].value;
      if(pass!=pass2){
        this.wrong = true;
        this.errorMessage = "Lozinke se moraju poklapati"
        return;
      }
      this.user = new UserReg();
      this.user.email = this.registrationForm.controls['email'].value;
      this.user.password = this.registrationForm.controls['password'].value;
      this.user.adresa = this.registrationForm.controls['adresa'].value;
      this.user.broj = this.registrationForm.controls['broj'].value;
      this.user.drzava = this.registrationForm.controls['drzava'].value;
      this.user.grad = this.registrationForm.controls['grad'].value;
      this.user.ime = this.registrationForm.controls['ime'].value;
      this.user.prezime = this.registrationForm.controls['prezime'].value;
      //this.user = this.registrationForm.value;
      console.log(this.user);
      this.regService.signup(this.user).subscribe( 
        result => {
          alert("Korisnik je kreiran");
          this.route.navigate(['/']);
        },        
        (err:Error) =>{
          this.errorMessage = err.message;
          this.wrong = true;
        });
      
  }
}
