import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Brod } from 'src/app/models/brod';
import { BrodService } from 'src/app/services/brod.service';

@Component({
  selector: 'app-brod-profil',
  templateUrl: './brod-profil.component.html',
  styleUrls: ['./brod-profil.component.scss']
})
export class BrodProfilComponent implements OnInit {

  id : {} ;
  brod: Brod;
  brodForm: FormGroup;

  constructor(private fb: FormBuilder, private _Activatedroute:ActivatedRoute, private brodService: BrodService) { }

  ngOnInit(): void {
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    console.log(this.id);

    this.brodForm = this.fb.group({
      'naziv':[''],
      'opis':[''],
      'pravila':[''],
      'cenovnik':[''],
      'adresa':[''],
      'ocena':['']
    })
    this.id = this._Activatedroute.snapshot.paramMap.get("id");
    //console.log(this.id);
    this.brodService.getBrod(this.id).subscribe(
      result => {
        console.log(result.body);
        this.brod = result.body;
        this.brodForm.patchValue({
          'naziv' : this.brod.naziv,
          'opis':this.brod.opis,
          'adresa':this.brod.adresa,
          'ocena':this.brod.ocena,
          'cenovnik':this.brod.cenovnik
        });
      },
      error => {
        console.log(error);
      }
    );
  }

  

}
