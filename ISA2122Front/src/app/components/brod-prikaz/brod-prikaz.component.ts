import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Brod } from 'src/app/models/brod';
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

  constructor(private brodoviService: BrodService, public router: Router) { }

  ngOnInit(): void {
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

  onSubmit(nesto):void{

  }

  setDatum(nesto):void{

  }
}
