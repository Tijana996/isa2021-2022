import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserReg } from 'src/app/models/userregister';
import { AuthentificationService } from 'src/app/services/authentification.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.scss']
})
export class RegisterAdminComponent implements OnInit {
  predefinisan : boolean;
  user: UserReg;
  registrationAdminForm: FormGroup;
  wrong: boolean;
  errorMessage: string;

  constructor(private fb: FormBuilder, public router: Router,
    private regService : AuthentificationService,) {
      this.wrong = false; 
      this.user = new UserReg();
      this.registrationAdminForm = this.fb.group({
        'email':['',[Validators.required, Validators.email]],
        'password' : ['', Validators.required],
        'passwordc' : ['', Validators.required],
        'adresa' : ['', Validators.required],
        'drzava' : ['', Validators.required],
        'broj' : ['', Validators.required],
        'grad' : ['', Validators.required],
        'ime' : ['', Validators.required],
        'prezime' : ['', Validators.required],
      });
     }

  ngOnInit(): void {
    this.regService.checkIfPredefinisan().subscribe(
      result => {
        console.log(result);
        if (result)
          this.predefinisan = true;
        else
          this.predefinisan = false;
      },
      error => {
        console.log(error);
      }
    );
  }

  onSubmit(){
    var pass = this.registrationAdminForm.controls['password'].value;
    var pass2 = this.registrationAdminForm.controls['passwordc'].value;
    if(pass!=pass2){
      this.wrong = true;
      this.errorMessage = "Lozinke se moraju poklapati"
      return;
    }
    this.user = new UserReg();
    this.user.email = this.registrationAdminForm.controls['email'].value;
    this.user.password = this.registrationAdminForm.controls['password'].value;
    this.user.adresa = this.registrationAdminForm.controls['adresa'].value;
    this.user.broj = this.registrationAdminForm.controls['broj'].value;
    this.user.drzava = this.registrationAdminForm.controls['drzava'].value;
    this.user.grad = this.registrationAdminForm.controls['grad'].value;
    this.user.ime = this.registrationAdminForm.controls['ime'].value;
    this.user.prezime = this.registrationAdminForm.controls['prezime'].value;
    this.user.tipKorisnika = "ADMIN";
    this.user.obrazlozenje = null;

    console.log(this.user);
    this.regService.signupAdmin(this.user).subscribe( 
      result => {
        alert("Kreiran je novi admin!");
        this.router.navigate(['/home-page-admin']);
      },        
      (err:Error) =>{
        this.errorMessage = err.message;
        this.wrong = true;
      });
    
}

}
