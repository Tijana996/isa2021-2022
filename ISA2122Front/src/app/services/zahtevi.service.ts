import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ZahtevReg } from '../models/zahtev';

@Injectable({
  providedIn: 'root'
})
export class ZahteviService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  private readonly zahteviPath = 'http://localhost:8080/auth/applications';

  constructor(private http: HttpClient) { }

  getZahtevi() : Observable<ZahtevReg[]>{
    let httpOptions = {};

    httpOptions = {
        headers: this.headers,
        observe: 'body',

    };

    return this.http.get<ZahtevReg[]>( this.zahteviPath, httpOptions);
}
}
