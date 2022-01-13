import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VikendicaService } from 'src/app/services/vikendica.service';

@Component({
  selector: 'app-vikendice-prikaz',
  templateUrl: './vikendice-prikaz.component.html',
  styleUrls: ['./vikendice-prikaz.component.scss']
})
export class VikendicePrikazComponent implements OnInit {

  vikendice : [];

  constructor(private vikendicaService: VikendicaService, public router: Router) { }

  ngOnInit(): void {
    this.vikendicaService.getVikendice().subscribe(
      result => {
        console.log(result.body);
        this.vikendice = result.body;
      },
      error => {
        console.log(error);
      }
    );
    //console.log(this.vikendicaService.getVikendice());
  }

  detalji(id) : void{
    console.log(id);
    this.router.navigate(['/vikendica/'+id]);
  }

}
