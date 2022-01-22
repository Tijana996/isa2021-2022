import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserProfile } from 'src/app/models/userprofile';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { ZahteviZaBrisanjeService } from 'src/app/services/zahtevizabrisanje.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  user: UserProfile;
  oldUser: UserProfile;
  userForm: FormGroup;
  submitionErrorUser: boolean = false;
  userNotFound: boolean = false;
  us : string = '';
  lek : [];
  klijent : boolean;

  constructor(private fb: FormBuilder, private authService: AuthentificationService, public router: Router, private zahteviService: ZahteviZaBrisanjeService) { 
    this.user = new UserProfile();
    this.klijent = authService.isKlijent();
    this.oldUser = new UserProfile();
    this.userForm = this.fb.group({
      'email':[''],
      'ime': ['', Validators.required ],
      'prezime': ['' , Validators.required],
      'adresa': ['' , Validators.required],
      'grad': ['' , Validators.required],
      'drzava': ['', Validators.required ],
      'broj': ['', Validators.required ],
      'poeni': ['' ],
      'kategorija': ['' ],
      'penali' : [''],
      'password':['']
    })
  }

  ngOnInit(): void {
    this.loadUser();
    console.log(this.user)
  }

  loadUser() {
    this.authService.getUser().subscribe(
      result => {
        this.user = result as unknown as UserProfile;
        this.userForm.patchValue({
          'email' : this.user.email,
          'ime':  this.user.ime,
          'prezime':  this.user.prezime,
          'adresa':  this.user.adresa,
          'grad':  this.user.grad,
          'drzava':  this.user.drzava,
          'broj':  this.user.broj,
          'poeni':  this.user.poeni,
          'kategorija':  this.user.kategorija,
          'penali':  this.user.penali,
          'password':''
        })
      },
      error => {
        this.submitionErrorUser = true;
      }
    );
  }

  onSubmit(forma){
    let Uid = JSON.parse(localStorage.getItem('currentUser') || "")?.id;
    console.log(forma);
    //this.user = new UserProfile();
    this.user.adresa = this.userForm.controls['adresa'].value;
    this.user.broj = this.userForm.controls['broj'].value;
    this.user.drzava = this.userForm.controls['drzava'].value;
    this.user.grad = this.userForm.controls['grad'].value;
    this.user.ime = this.userForm.controls['ime'].value;
    this.user.prezime = this.userForm.controls['prezime'].value;
    this.user.password = this.userForm.controls['password'].value == undefined ? this.user.password : this.userForm.controls['password'].value;
    this.authService.updateUser(this.user).subscribe(
      resData => {
        console.log(resData);
        this.router.navigate['/home-page-user'];
      });
  }

  delete(){
    let Uid = JSON.parse(localStorage.getItem('currentUser') || "")?.id;
    console.log(Uid);
    this.zahteviService.addZahtev(Uid).subscribe(
      result => {
        console.log(result);
      },
      error => {
        console.log(error);
      }
    );
  }

}
