import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ZahtevReg } from '../models/zahtev';

@Injectable({
  providedIn: 'root'
})
export class ZahteviZaBrisanjeService {

  private headers = new HttpHeaders({'Content-Type': 'application/json'});

  private readonly zahteviPath = 'http://localhost:8080/zahtevibrisanje';

  constructor(private http: HttpClient) { }

  getZahtevi() : Observable<any>{
    let httpOptions = {};

    httpOptions = {
        headers: this.headers,
        observe: 'body',

    };

    return this.http.get<any>( this.zahteviPath, httpOptions);
}

    addZahtev(id): Observable<any>{
        let httpOptions = {};

        httpOptions = {
            headers: this.headers,
            observe: 'body',

        };

        return this.http.put<any>( this.zahteviPath+'/'+id, httpOptions);
    }

    deleteZahtev(id): Observable<any>{
        let httpOptions = {};

        httpOptions = {
            headers: this.headers,
            observe: 'body',

        };

        return this.http.delete<any>( this.zahteviPath+'/'+id, httpOptions);
    }
}
