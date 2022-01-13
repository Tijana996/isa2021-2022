import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserProfile } from 'src/app/models/userprofile';
import { AuthentificationService } from 'src/app/services/authentification.service';

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

  constructor(private fb: FormBuilder, private authService: AuthentificationService, public router: Router) { 
    this.user = new UserProfile();
    this.oldUser = new UserProfile();
    this.userForm = this.fb.group({
      'email':['',[Validators.required, Validators.email]],
      'ime': ['', Validators.required],
      'prezime': ['', Validators.required],
      'adresa': ['', Validators.required],
      'grad': ['', Validators.required],
      'drzava': ['', Validators.required],
      'broj': ['', Validators.required],
      'poeni': ['', Validators.required],
      'kategorija': ['', Validators.required],
      'penali' : ['']
    })
  }

  ngOnInit(): void {
    this.loadUser();
    console.log(this.user)
  }

  loadUser() {
    this.authService.getUser().subscribe(
      result => {
        console.log("sara " + result);
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
        })
      },
      error => {
        this.submitionErrorUser = true;
      }
    );
  }

  onSubmit(){
    let Uid = JSON.parse(localStorage.getItem('currentUser') || "")?.id;
    console.log(Uid);
  }

}
