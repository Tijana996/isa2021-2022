import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Brod } from 'src/app/models/brod';
import { Search } from 'src/app/models/search';
import { AuthentificationService } from 'src/app/services/authentification.service';
import { BrodService } from 'src/app/services/brod.service';

@Component({
  selector: 'app-brod-prikaz',
  templateUrl: './brod-prikaz.component.html',
  styleUrls: ['./brod-prikaz.component.scss']
})
export class BrodPrikazComponent implements OnInit {

  brodovi : any[];
  brodoviPravo: [];
  datum : string;
  klijent : boolean;

  constructor(private brodoviService: BrodService, public router: Router, private service: AuthentificationService) { }

  ngOnInit(): void {
    this.klijent = this.service.isKlijent();
    this.brodoviService.getBrodovi().subscribe(
      result => {
        console.log(result.body);
        this.brodovi = result.body;
        this.brodoviPravo = result.body;
      },
      error => {
        console.log(error);
      }
    );
  }

  detalji(id) : void{
    console.log(id);
    this.router.navigate(['/brod/'+id]);
  }

  onSearchChange(nesto : string) :void{
      console.log(nesto);
      if(nesto == "") {
        this.brodovi = this.brodoviPravo;
        return;
      }
      this.brodovi = [] as any;
      for(let i = 0 ; i < this.brodoviPravo.length; i++)
      {
          console.log(this.brodoviPravo[i]);
          var v = new Brod;
          v = this.brodoviPravo[i];
          if(v.naziv.includes(nesto) || v.adresa.includes(nesto))
          {
            this.brodovi.push(v);
          }
      }
  }

  onSubmit(form : NgForm){
    console.log(form.value.dateod);
    //form.value.ocena = form.value.ocena==''?0:form.value.ocena;
    var searchObj = new Search();
    searchObj.ocena = form.value.ocena=='' || form.value.ocena==null?0:form.value.ocena;
    searchObj.datedo = form.value.datedo;
    searchObj.dateod = form.value.dateod;
    searchObj.lokacija = form.value.lokacija;
    console.log(searchObj);
    this.brodoviService.getBrodSearch(searchObj.dateod, searchObj.datedo,searchObj.lokacija,searchObj.ocena).subscribe(
      result => {
        console.log(result);
        this.brodovi = result;
        this.brodoviPravo = result;
      },
      error => {
        //console.log(error);
      }
    );
  }

  setDatum(datum : string){
    this.datum = datum;
  }

  rezervisi(id:number){
    console.log(id);
    console.log(this.datum);
    if(this.datum == undefined) 
    {
      alert("Unesite datum da biste izvrsili rezervaciju");
      return;
    }
    this.router.navigate(['/rezervacija/brod/'+id+'/'+this.datum]); 
  }
}
