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

  selectedTip: string;

  tipovi: any[];

  constructor(
    private fb: FormBuilder,
    private route : Router,
    private regService : AuthentificationService
  ) {
    this.wrong = false; 
    this.user = new UserReg();
    this.selectedTip = '';
    this.tipovi = [
      {value: 'KLIJENT', viewValue: 'Klijent'},
      {value: 'INSTRUKTOR', viewValue: 'Instruktor pecanja'},
      {value: 'VLASNIKVIKENDICE', viewValue: 'Vlasnik vikendice'},
      {value: 'VLASNIKBRODA', viewValue: 'Vlasnik broda'},
    ];
    this.registrationForm = this.fb.group({
      'tip_korisnika' :['',Validators.required],
      'email':['',[Validators.required, Validators.email]],
      'password' : ['', Validators.required],
      'passwordc' : ['', Validators.required],
      'adresa' : ['', Validators.required],
      'drzava' : ['', Validators.required],
      'broj' : ['', Validators.required],
      'grad' : ['', Validators.required],
      'ime' : ['', Validators.required],
      'prezime' : ['', Validators.required],
      'obrazlozenje' : ['']
    });
  }

  ngOnInit(): void {
  }

  onSelectionChanged(event: any) {
    if(this.registrationForm.controls['tip_korisnika'].value == 'KLIJENT'){
      this.registrationForm.controls['obrazlozenje'].reset();
      this.registrationForm.controls['obrazlozenje'].disable();
    }
    else
      this.registrationForm.controls['obrazlozenje'].enable();
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
      this.user.tipKorisnika = this.registrationForm.controls['tip_korisnika'].value;
      this.user.email = this.registrationForm.controls['email'].value;
      this.user.password = this.registrationForm.controls['password'].value;
      this.user.adresa = this.registrationForm.controls['adresa'].value;
      this.user.broj = this.registrationForm.controls['broj'].value;
      this.user.drzava = this.registrationForm.controls['drzava'].value;
      this.user.grad = this.registrationForm.controls['grad'].value;
      this.user.ime = this.registrationForm.controls['ime'].value;
      this.user.prezime = this.registrationForm.controls['prezime'].value;
      //this.user = this.registrationForm.value;

      if (this.user.tipKorisnika != 'KLIJENT'){
        this.user.obrazlozenje = this.registrationForm.controls['obrazlozenje'].value;
      }
      else{
        this.user.obrazlozenje = null;
      }

      console.log(this.user);
      this.regService.signup(this.user).subscribe( 
        result => {
          alert("Zahtev za kreiranje naloga je poslat!");
          this.route.navigate(['/']);
        },        
        (err:Error) =>{
          this.errorMessage = err.message;
          this.wrong = true;
        });
      
  }
}
