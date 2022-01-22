import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Instruktor } from 'src/app/models/instruktor';
import { InstruktorService } from 'src/app/services/instruktor.service';

@Component({
  selector: 'app-istruktor-profil',
  templateUrl: './istruktor-profil.component.html',
  styleUrls: ['./istruktor-profil.component.scss']
})
export class IstruktorProfilComponent implements OnInit {

  id : {} ;
  instruktorForm : FormGroup;
  instruktor : Instruktor;

  constructor(private fb: FormBuilder, private _Activatedroute:ActivatedRoute, private service:InstruktorService) { }

  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    console.log(this.id);

    this.instruktorForm = this.fb.group({
      'ime':[''],
      'prezime':[''],
      'broj':[''],
      'lokacija':[''],
      'ocena':['']
    })
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    //console.log(this.id);
    this.service.getInstruktor(this.id).subscribe(
      result => {
        console.log(result.body);
        this.instruktor = result.body;
        this.instruktorForm.patchValue({
          'ime' : this.instruktor.ime,
          'prezime':this.instruktor.prezime,
          'broj':this.instruktor.broj,
          'lokacija':this.instruktor.lokacija,
          'ocena':this.instruktor.ocena
        });
      },
      error => {
        console.log(error);
      }
    );
  }
}
